package ch18.sec08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamExample {

	public static void main(String[] args) {

		// 기본 타입 스트림.
		// 보조 스트림이고 사용하게 되면 byte와 문자만 입출력 할수 있었지만 문자열,정수,실수,논리타입인 기본 타입도 쉽게 
		// 입출력 할수 있다.
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.db");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF("홍길동");
			dos.writeDouble(97.5);
			dos.writeInt(1);
			
			dos.writeUTF("김길동");
			dos.writeDouble(75.5);
			dos.writeInt(2);
			
			dos.flush();
			dos.close();
			
			FileInputStream fis = new FileInputStream("C:/Temp/primitive.db");
			DataInputStream dis = new DataInputStream(fis);
			
			for(int i = 0; i < 2; i++) {
				
				String str = dis.readUTF();
				Double score = dis.readDouble();
				int num = dis.readInt();
				
				if(str == null)
					break;
				
				System.out.println(str + " " + score + " " + num);
			}
			
			dis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
