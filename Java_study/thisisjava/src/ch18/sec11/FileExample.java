package ch18.sec11;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) {

		File dir = new File("C:/Temp/images");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File("C:/Temp/file3.txt");
		
		if(!dir.exists())
			dir.mkdirs();
		
		try {
			if(!file1.exists())
				file1.createNewFile();
			if(!file2.exists())
				file2.createNewFile();
			if(!file3.exists())
				file3.createNewFile();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File temp = new File("C:/Temp");
		File[] contents = temp.listFiles();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		Arrays.stream(contents)
		.forEach(t -> {
			System.out.printf("%-25s",format.format(new Date(t.lastModified())));
			if(t.isDirectory()) {
				System.out.printf("%-10s%-20s","<DIR>",t.getName());
			} else {
				System.out.printf("%s%-8s %-20s",(int)Math.ceil(t.length()/1000.0),"KB",t.getName());
			}
			System.out.println();
		});
		
	}

}
