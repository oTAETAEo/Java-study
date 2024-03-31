package ch18.sec10;

import java.io.Serializable;

public class Product implements Serializable{
	
	// serialVersionUID는 다른 쪽으로 객체를 이동 시킬때 같은 시리얼 숫자를 가지고 있으면 직렬화된 필드를 공통으로 포함하고 있다면
	// 예외 없이 이동시킬수 있다.
	// serialVersionUID 아이디가 동일하지 않고 필드가 다르다면 InvalidClassException 예외가 발생한다.
	private static final long serialVersionUID = -621812868470078544L;
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + ": " + price;
	}
	
}
