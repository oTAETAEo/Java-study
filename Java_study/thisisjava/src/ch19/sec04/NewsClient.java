package ch19.sec04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class NewsClient {

	public static void main(String[] args) {
		
		try {
			// 자동으로 부여된 port 번호를 사용하기 때문에 지정해 주지 않는다.
			DatagramSocket datagramSocket = new DatagramSocket();
			
			// 구독하고 싶은 주제 보내기.
			String data = "정치";
			byte[] bytes = data.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length,new InetSocketAddress("localhost",50001));
			datagramSocket.send(sendPacket);
			
			
			while(true) {
				
				// 뉴스 받기
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivePacket);

				// 문자열 변환.
				String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
				System.out.println(news);
				
				// 10번째 뉴스를 받으면 종료
				if(news.contains("뉴스10")) {
					break;					
				}
				
			}
			
			// DatagramSocket 닫기.
			datagramSocket.close();
			
		} catch (IOException e) {
			System.out.println("[클라이언트] " + e.getMessage());
		}
		
		
	}

}
