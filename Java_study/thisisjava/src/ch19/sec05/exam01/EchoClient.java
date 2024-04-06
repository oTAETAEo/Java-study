package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost",50001);
			System.out.println("[클라이언트] 연결 성공.");
// -----------------------------------------------------------------------------------

			String sendMessage= "나는 자바가 좋아!";
//			OutputStream os = socket.getOutputStream();
//			byte[] bytes = sendMessage.getBytes("UTF-8");
//			os.write(bytes);
//			os.flush();
//			System.out.println("[클라이언트] 데이터 보냄 " + sendMessage);
//
//			InputStream is = socket.getInputStream();
//			bytes = new byte[1024];
//			int readByteCount = is.read(bytes);
//			String receiveMessage = new String(bytes,0,readByteCount,"UTF-8");
//			System.out.println("[클라이언트] 데이터 받음 " + receiveMessage);

			// 문자열을 좀더 쉽게 보내고 싶으면 DataOutputstream, DataInputStream을 사용하면 된다.
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			System.out.println("[클라이언트] 데이터 보냄 " + sendMessage);

			// 받을때도 사용하면 편하지만 상대방이 DataOutputStream으로 문자열을 보낼때만 사용 가능하다.
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음 " + receiveMessage);
			
// -----------------------------------------------------------------------------------

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
