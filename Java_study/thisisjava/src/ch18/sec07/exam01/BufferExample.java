package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {

	public static void main(String[] args) {

		try {
			
			// 버퍼가 없는 스트림 생성.
			String originalFilePath1 = BufferExample.class.getResource("originalFile1.jpg").getPath();
			String targetFilePath1 = "C:/Temp/targetFile1.jpg";
		
			FileInputStream fis1 = new FileInputStream(originalFilePath1);
			FileOutputStream fos1 = new FileOutputStream(targetFilePath1);
			
			// 버퍼가 있는 스트림 생성.
			String originalFilePath2 = BufferExample.class.getResource("originalFile2.jpg").getPath();
			String targetFilePath2 = "C:/Temp/targetFile2.jpg";
					
			FileInputStream fis2 = new FileInputStream(originalFilePath2);
			BufferedInputStream bis = new BufferedInputStream(fis2);

			FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
			BufferedOutputStream bos = new BufferedOutputStream(fos2);
			
			long Time1 = copy(fis1, fos1);
			System.out.println("버퍼 미사용: " + Time1);
			
			long Time2 = copy(bis, bos);
			System.out.println("버퍼 사용: " + Time2);
			
			fis1.close();
			fos1.close();
			
			bis.close();
			bos.close();
			

		}catch (IOException e) {
		}
		
	}
	
	public static long copy(InputStream is, OutputStream os) throws IOException {
		long start = System.nanoTime();
		
		while (true) {
			int data = is.read();
			if(data == -1)
				break;
			os.write(data);
		}
		
		long end = System.nanoTime();
		return end-start;
	}
}
