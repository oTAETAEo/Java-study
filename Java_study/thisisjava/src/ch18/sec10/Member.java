package ch18.sec10;

import java.io.Serializable;

// Serializable 외부로 출력 할수 있게해주는 인터페이스 (직렬화 가능표시)
// 구현할 메소드는 없다.
public class Member implements Serializable{
	
	private static final long serialVersionUID = 6237230879659378975L;
	private String name;
	private String id;
	
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + ": " + name;
	}
	
}
