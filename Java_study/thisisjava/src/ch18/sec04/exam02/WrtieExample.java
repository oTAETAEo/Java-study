package ch18.sec04.exam02;

import java.io.FileReader;
import java.io.Reader;

public class WrtieExample {

	public static void main(String[] args) {

		
		try (Reader reader = new FileReader("C:/Temp/test.txt");
				Reader reader2 = new FileReader("C:/Temp/test.txt")){
						
			// 한 문자씩 읽기.
			while (true) {
				int data = reader.read();
				if(data == -1)
					break;
				System.out.print((char)data);
			}
			
			char[] arr = new char[100];
			
			System.out.println();
			
			while (true) {

				int data = reader2.read(arr);
				if(data == -1)
					break;
				for(int i = 0; i < data; i++) {
					System.out.print(arr[i]);
				}
			}
			
			// 한번 사용한 스트림은 재탕이 되지 않는다.
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
