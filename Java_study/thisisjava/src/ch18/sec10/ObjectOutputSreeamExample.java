package ch18.sec10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ObjectOutputSreeamExample {

	public static void main(String[] args) {

		try {
			
			// 객체 출력 보조 스트림 생성 (바이트 기반)
			ObjectOutput oos = new ObjectOutputStream(new FileOutputStream("C:/Temp/object.dat"));
			
			Member m1 = new Member("홍길동", "fall");
			Product p1 = new Product("노트북",150000);
			int[] arr1 = {1,2,3};
			
			// 객체를 직렬화 하는 메소드.
			oos.writeObject(m1);
			oos.writeObject(p1);
			oos.writeObject(arr1);
			
			oos.flush(); oos.close();
			
		} catch (IOException  e) {
			e.printStackTrace();
		}
		
	}

}
