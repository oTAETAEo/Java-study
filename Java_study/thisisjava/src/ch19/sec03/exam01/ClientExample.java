package ch19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost",50001);
			System.out.println("[클라이언트] 연결 성공.");
			
			socket.close();
			System.out.println("[클라이언트] 연결 끊음.");
		} catch (UnknownHostException e) {
			// UnknownHostException : IP주소가 잘못 표기 되어있는 경우.
			System.out.println(e.toString());
		} catch (IOException e) {
			// 서버가 열려 있지 않은 경우.
			// IOException : 제공된 IP와 Port 번호를 사용할수 없는경우 발생.
			System.out.println(e.toString());
		}
	
	}

}
