package ch19.sec02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdderssExample {

	public static void main(String[] args) {

		try {
			InetAddress address1 = InetAddress.getLocalHost();
			System.out.println("나의 ip 주소 : " + address1.getHostAddress());
			
			String add = "www.naver.com";
			InetAddress[] address2 = InetAddress.getAllByName(add);
			
			for(InetAddress a : address2) {
				System.out.println("www.naver.com의 ip 주소 : " + a.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
