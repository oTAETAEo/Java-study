package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {

		// FileNotFoundException 이 예외는 폴더가 없을때 실행된다 파일은 폴더가 있으면 생성 돠면서 실행된다.
//		OutputStream os = null;
//		try {
//			os = new FileOutputStream("C:/Temp/test1.db");
//			
//			byte a = 10;
//			
//			// 버퍼에 저장 되기만 한다.
//			os.write(a);
//		
//			// 버퍼에 있는 스트림이 실행된다.
//			os.flush();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				os.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		// 오토 클로즈를 구현 하고 있기 때문에 자동으로 close가 된다.
		// FileOutputStream("C:/Temp/test1.db",ture)는 이미 파일이 있을경우 덮어쓰기 할지 있는 파일에
		// 뒤에 추가를 할지를 bool 타입으로 인자값을 받는다.
		try (OutputStream os = new FileOutputStream("C:/Temp/test1.db")){
			byte a = 10;
			byte b = 20;
			byte c = 30;

			os.write(a);
			os.write(b);
			os.write(c);
			
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
