package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {

		try(InputStream is = new FileInputStream("C:/Temp/test2.db")) {
			
			byte[] arr = new byte[100];
			
			while (true) {
				int count = is.read(arr);
				if(count == -1)
					break;
				
				for(int i = 0; i < count; i++)
					System.out.println(arr[i]+ " ");
				
			}
			
		} catch (Exception e) {
		}
	}

}
