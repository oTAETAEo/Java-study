package ch18.sec11;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {

	public static void main(String[] args) {

		try {
			
			String data = "" +
					"id: winter\n" +
					"email: dksl58@naver.com\n" +
					"tel: 010-134-4567";
			
			Path files = Paths.get("C:/Temp/user.txt");
			
			Files.writeString(Paths.get("C:/Temp/user.txt"),data,Charset.forName("UTF-8"));
			
			System.out.println(Files.probeContentType(files));
			System.out.println((int)Math.ceil(Files.size(files)/1000.0)+"KB");
			
			String content = Files.readString(files);
			System.out.println(content);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
