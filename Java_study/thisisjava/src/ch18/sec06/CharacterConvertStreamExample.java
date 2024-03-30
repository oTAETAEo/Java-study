package ch18.sec06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {

	public static void main(String[] args) {

		try{
			
			write("문자 변환 스트림을 사용합니다.");
			String str2 = read();
			System.out.println(str2);
			
		} catch (Exception e) {

		}
	}
	
	public static void write(String str) throws IOException{
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		Writer writer = new OutputStreamWriter(os,"UTF-8");
		
		// FileOutputStream 만 사용 했을 경우 (보조스트림 사용x)
//		byte[] data = str.getBytes("UTF-8");
//		os.write(data);
//		os.flush();
		
		writer.write(str);
		writer.flush();
		writer.close();

	}
	
	public static String read() throws IOException {

//		InputStream is = new FileInputStream("C:/Temp/test.txt");
//		Reader reader = new InputStreamReader(is,"UTF-8");
		
		// FileInputStream 만 사용 했을 경우 (보조스트림 사용x)
//		byte[] data = new byte[100];
//		int num = is.read(data);
//		String str2 = new String(data,"UTF-8");
//		System.out.println(str2);
		
//		char[] arr = new char[100];
//		int num = reader.read(arr);
//		String str2 = new String(arr,0,num);
//		reader.close();
		
		// 상황에 맞는 보조 스트림을 사용한다면 코드가 간결해질수 있다.
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		Reader reader = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(reader);
		
		// 위에 코드의 기능을 한줄로 대체 가능.
		String str2 = br.readLine();
		
		return str2;
	}

}
