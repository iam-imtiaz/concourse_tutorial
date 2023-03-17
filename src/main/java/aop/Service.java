package aop;

import org.springframework.stereotype.Component;

@Component
public class Service {
	public void addAccount() {
		System.out.println("From add account");
	}
	public int getBalance() {
		System.out.println("From get bal");
		return 2000;
	}
	

	public int meth()  throws Exception{
		throw new Exception("Throeing ex");
	}
}
