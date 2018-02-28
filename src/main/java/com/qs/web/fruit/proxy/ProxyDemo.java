package com.qs.web.fruit.proxy;


public class ProxyDemo {

	
	public static void main(String[] args) {
	
		MyInvocationHandle handle=new MyInvocationHandle();
		Subject subject=(Subject) handle.bind(new SubjectImpl());
		String re=subject.saySomething("帅哥", "27");
		System.out.println(re);
	}

}
