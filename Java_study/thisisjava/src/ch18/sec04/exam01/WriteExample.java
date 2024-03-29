package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) {

		// 문자 출력 스트림.
		// Autoclose
		try(Writer writer = new FileWriter("C:/Temp/test.txt")) {
			
			char a = 'A';
			writer.write(a);
			
			char b = 'B';
			writer.write(b);
			
			char[] arr1 = {'1','2','3'};
			writer.write(arr1);
			
			writer.write("chl");
			
			String arr2 = "abc";
			writer.write(arr2);
			
			writer.flush();
			
		} catch (Exception e) {
		}
		
	}

}
