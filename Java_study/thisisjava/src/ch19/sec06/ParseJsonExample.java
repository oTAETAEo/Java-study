package ch19.sec06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJsonExample {

	public static void main(String[] args) {

		try {
			
			// json 파일을 파싱 하는 방법.
			// JSONObject 객체 안에 JSONObject 객체가 또 있다면 getJSONObject() 메소드를 통해 객체를 가져온뒤 타입에 맞는 get 메소드를 싱행한다.
			// JSONObject 객체 안에 JSONArray 객체가 있다면 JSONArray 변수에 getJSONArray() 메소드를 통해 배열을 가져온뒤 배열 관련 메소드로 데이터를 볼수 있다.
			BufferedReader br = new BufferedReader(new FileReader("C:/Temp/member.json",Charset.forName("UTF-8")));
			String json = br.readLine();
			br.close();
			
			JSONObject root = new JSONObject(json); 
			
			System.out.println("id: " + root.getString("id"));
			System.out.println("name: " + root.getString("name"));
			System.out.println("age: " + root.getInt("age"));
			System.out.println("student: " + root.getBoolean("student"));
			
			JSONObject tel = root.getJSONObject("tel");
			System.out.println("home: " + tel.getString("home"));
			System.out.println("mobile: " + tel.getString("mobile"));
			
			JSONArray skill = root.getJSONArray("skill");
			System.out.print("skill: ");
			for(int i = 0; i < skill.length(); i++) {
				System.out.print(skill.get(i) + ", ");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
