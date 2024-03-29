package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		
		// 배열에 저장되어 있는 바이트 출력.
		
		
		// AutoClose 사용방법.
		// FileOutputStream() 경로에 이미 파일이 없다면 생성하고 출력이 되고 이미 있다면 2번째 매개변수에 true false 값을 주면
		// true는 바이트를 추가할지 false는 그 파일에 덮어쓰기 할지를 정한다.
		// 예외가 발생되는 경우는 경로에 적은 폴더 그 자체가 없으면 발생한다. 
		try (OutputStream ou = new FileOutputStream("C:/Temp/test2.db")){
			
			byte[] arr = {10,20,30,40,50};
			
			ou.write(arr);
			
			ou.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
