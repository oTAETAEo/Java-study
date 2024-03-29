package ch18.sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {

		// AutoClose 사용 .
		try(OutputStream os = new FileOutputStream("C:/Temp/test3.db")) {
			
			byte[] arr = {10,20,30,40,50};
			
			// 배열, 시작 인덱스, 부터 몇개.
			os.write(arr,1,3);
			
			os.flush();
			
		} catch (IOException e) {

		}
		
	}

}
