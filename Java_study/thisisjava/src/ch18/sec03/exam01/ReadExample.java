package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {

		// AutoCloes 
		try(InputStream is = new FileInputStream("C:/Temp/test1.db")) {
			
			// 위의 경로에 있는 파일에서 1바이트씩 데이터를 가져온다 (read).
			// 가져올 데이터가 없다면 -1 을 리턴함으로 이것을 이용해 데이터의 마지막까지 가져올수 있다.
			while(true) {
				int data = is.read();
				if(data == -1)
					break;
				System.out.println(data);
			}
			
		} catch (IOException e) {
			// 위의 경로가 없다면 FileNotFoundException 예외가 나온다.
			e.printStackTrace();
		}
		
	}

}
