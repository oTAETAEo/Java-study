package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadExample {

	public static void main(String[] args) {

		// 파일 복사 예제.
		String originalFileName = "C:/Temp/test.jpg";
		String targetFileName = "C:/Temp/test2.jpg";
		
		try (InputStream in = new FileInputStream(originalFileName);
			OutputStream os = new FileOutputStream(targetFileName)){

			byte[] arr = new byte[1024];
			
			while(true) {
				int count = in.read(arr);
				if(count == -1)
					break;
				// 버퍼에 대기중.
				os.write(arr);
			}
			
			// 잔류 데이터 출력해 버퍼를 비운다.
			os.flush();
			
		} catch (IOException e) {
			
		}
		
	}

}
