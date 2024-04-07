package ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.json.JSONObject;

public class ChatServer {
	
	ServerSocket serverSocket;
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());
	
	// 메소드
	public void start() throws IOException{
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작됨.");
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					while(true) {						
						// 클라이언트의 연결요청 수락.
						Socket socket = serverSocket.accept();
						// 람다식에 this가 사용되면 람다식에서 만들어진 객체가 들어가는게 아니라 밖에있는 클래스 객체를 의미한다.
						SocketClient sc = new SocketClient(ChatServer.this, socket);
					}
				} catch(Exception e) {
					
				}
			}
		};
		thread.start();
	}
	
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: " + key);
		System.out.println("현재 사용자 수: " + chatRoom.size() + '\n');
	}
	
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("나감: " + key);
		System.out.println("현재 사용자 수: " + chatRoom.size() + '\n');
	}
	
	public void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp",sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		Collection<SocketClient> socketClients = chatRoom.values();
		for(SocketClient sc: socketClients) {
			if(sc == sender) continue;
			sc.send(json);
		}
	}
	
	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdown();
			chatRoom.values().stream().forEach(t -> t.close());
		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println("[서버] 종료됨.");
	}
	
	public static void main(String[] args) {
		
		try {
			
			ChatServer chatServer = new ChatServer();
			chatServer.start();
			
			System.out.println("---------------------------------");
			System.out.println("서버를 종료 하려면 q 또는 Q를 입력하고 Enter를 누르세요.");
			System.out.println("---------------------------------");
				
			// 키보드 입력
			Scanner scanner = new Scanner(System.in);
			
			while (true) {

				// 종료문.
				String key = scanner.nextLine();
				if(key.toLowerCase().equals("q")) {
					break;
				}
			}
			
			scanner.close();
			
			// TCP 서버 종료.
			chatServer.stop();
			
		
		} catch (Exception e) {
			System.out.println("[서버] " + e.getMessage());
			// TODO: handle exception
		}
		
	}
	
	
}
