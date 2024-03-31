package ch18.sec10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ObjectInputStreamExample {

	public static void main(String[] args) {
		
		ObjectInput ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("C:/Temp/object.dat"));
			
			// 객체를 역직렬화 하는 메소드.
			Member m2 = (Member) ois.readObject();
			Product p2 = (Product) ois.readObject();
			int[] arr2 = (int[]) ois.readObject();
			
			System.out.println(m2);
			System.out.println(p2);
			System.out.println(Arrays.toString(arr2));
		
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
