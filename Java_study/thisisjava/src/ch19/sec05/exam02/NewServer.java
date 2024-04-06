package ch19.sec05.exam02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewServer {

	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	private static DatagramSocket datagramSocket;
	
	public static void main(String[] args) {

		System.out.println("---------------------------------");
		System.out.println("서버를 종료 하려면 q 또는 Q를 입력하고 Enter를 누르세요.");
		System.out.println("---------------------------------");
				
		// UCP 서버 시작
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
		
		// UCP 서버 종료.
		stopServer();
		
	}

	private static void startServer() {
		// 작업 스레드 정의.
		Thread thread = new Thread() {			
			@Override
			public void run() {
				
				try {
					// DatagramSocket 생성 및 Port 바인딩.
					datagramSocket = new DatagramSocket(50001);
					System.out.println("[서버] 시작됨.");
					
					while(true) {
						// 클라이언트가 구독하고 싶은 뉴스 주제 얻기.
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024],1024);
						System.out.println("클라이언트의 희망 뉴스를 얻기 위해 대기함.");
						// 데이터가 들어올때 까지 블록킹이 된다 (일시정지)
						datagramSocket.receive(receivePacket);
						
						executorService.execute(() -> {
							
							try {
								// 바이트 배열, 시작 Index, 끝 Index, 디코딩;
								String newsKind = new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
								
								// 쿨라이언트의 IP Port 번호 얻기.
								SocketAddress socketAddress = receivePacket.getSocketAddress();
								
								// 10개의 뉴스 클라이언트에 전송.
								for(int i = 1; i <= 100; i++) {
									String data = newsKind + ": 뉴스" + i;
									byte[] bytes = data.getBytes();
									DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
									datagramSocket.send(sendPacket);
									Thread.sleep(1000);
								}
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						});
					}					
				} catch (Exception e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		
		// 작업 스레드 시작
		thread.start();
	}

	private static void stopServer() {
		executorService.shutdown();
		datagramSocket.close();
		System.out.println("[서버] 종료됨.");

	}

}













