package ch19.sec06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {

	public static void main(String[] args) {

		
		// json 파일을 생성 하는 방법.
		// JSONObject로 객체를 생성하면 {} 형태로 생성.
		// JSONArray로 객체를 생성하면 [] 형태로 생성.
		JSONObject root = new JSONObject();
		
		root.put("id", "winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);
		
		JSONObject tel = new JSONObject();
		tel.put("home", "12-456-789");
		tel.put("mobile", "010-4564-7895");
		root.put("tel", tel);
		
		JSONArray skill = new JSONArray();
		skill.put("java");
		skill.put("c");
		skill.put("c++");
		root.put("skill", skill);
		
		String json = root.toString();
		System.out.println(json);
		
		try {
			Writer writer = new FileWriter("C:/Temp/member.json",Charset.forName("UTF-8"));
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
