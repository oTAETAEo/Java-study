package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineExample {

	public static void main(String[] args) {

		// BufferedReader 보조 스트림에는 readLine 메소드가 있어 한줄씩 읽어오기 편하다.
		try(BufferedReader reader = new BufferedReader(new FileReader("src/ch18/sec07/exam02/ReadLineExample.java"))) {
		
			int lineCount = 1;
			
			// 위 경로에 있는 문자를 읽어오는 코드 읽어 올게 없으면 null 반환.
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				System.out.println(lineCount + "\t" + str);
				lineCount++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
