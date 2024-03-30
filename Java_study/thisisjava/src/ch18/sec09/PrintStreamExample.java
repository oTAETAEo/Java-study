package ch18.sec09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamExample {

	public static void main(String[] args) {

		// 여태 사용했던 콘솔창에 프린트 하는것이 아닌 어느 위치에 있는 파일에 프린트(출력) 하는 스트림이다.
		// 보조 스트림이지만 flie 객체를 사용할때 주 스트림으로 사용 가능하다.
		// PrintWriter는 바이트 출력 기반, 문자 출력 기반 스트림이 둘다 올수 있다. 
		try (PrintStream stream = new PrintStream(new FileOutputStream("C:/Temp/printstream.txt"))){
			
			stream.print("마치");
			stream.println("프린터가 출력 하는것 처럼");
			stream.println("데이터를 출력합니다.");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// OutputStream, Writer 모두 올수 있다.
		try (PrintWriter stream1 = new PrintWriter(new FileOutputStream("C:/Temp/printstream.txt"));
			PrintWriter stream2 = new PrintWriter(new FileWriter("C:/Temp/printstream.txt"))){
			
			stream1.print("마치");
			stream1.println("프린터가 출력 하는것 처럼");
			stream1.println("데이터를 출력합니다.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
