package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

	// 동시 처리를 위한 스레드 풀 생성.
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	private static ServerSocket serverSocket;
	
	public static void main(String[] args) {

		System.out.println("---------------------------------");
		System.out.println("서버를 종료 하려면 q 또는 Q를 입력하고 Enter를 누르세요.");
		System.out.println("---------------------------------");
				
		// TCP 서버 시작
		startServer();
	
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
		stopServer();
	}
	

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			
			@Override
			public void run() {				
				try {
					// ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");

					// 여러 클라이언트의 연결 요청을 위한 무한 루프.
					while(true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						
						// 연결 수락 Socket 객체 리턴.
						Socket socket = serverSocket.accept();
						
						executorService.execute(() -> {
							try {
								InetSocketAddress address = (InetSocketAddress)socket.getRemoteSocketAddress();						
								// 연결 클라이언트의 정보 얻기.
								String clientIP = address.getHostString();
								int portNo = address.getPort();
								System.out.println("[서버] " + clientIP + "의 연결 요청을 수락함.");
		// -----------------------------------------------------------------------------------
								
//								// 데이터 받기.
//								InputStream is = socket.getInputStream();
//								byte[] bytes = new byte[1024];
//								int readByteCount = is.read(bytes);
//								String str = new String(bytes,0,readByteCount,"UTF-8");
//								// 데이터 보내기.
//								OutputStream os = socket.getOutputStream();
//								bytes = str.getBytes("UTF-8");
//								os.write(bytes);
//								os.flush();
								
//								System.out.println("[서버] 받은 데이터를 다시 보냄 " + str);

								// 데이터를 좀더 쉽게 입출력 하기 위해서 DataOutpurStream,DataInputStream을 사용하면 된다.
								// DataInputStream으로 받으려면 상대방이 DataOutputStream으로 보내야지만 사용할수 있다.
								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String message = dis.readUTF();
								
								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(message);
								dos.flush();
								System.out.println("[서버] 받은 데이터를 다시 보냄 " + message);

		// -----------------------------------------------------------------------------------

								// 연결 끊기
								socket.close();
								System.out.println("[서버] " + clientIP + "의 연결을 끊음.");
								
							} catch (IOException e) {
								System.out.println(e.getMessage());
							}											
						});
					}
					
				} catch (IOException e) {
					// Port 번호가 이미 사용중이거나 루프를 돌던중 q가 입력이 되어서 TCP 서버가 종료되면 accept() 실행부에서 예외가 발생하게 된다 (java.net.SocketException).
					// java.net.SocketException은 IOException의 자식 클래스이다.
					
					System.out.println("[서버] " + e.toString());
				}
				
			}
		};
		
		thread.start();
	}
	
	public static void stopServer(){
//		 serverSocket를 닫고 Port 언바인딩
		try {
			serverSocket.close();
			executorService.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}