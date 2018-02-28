package com.qs.web.fruit.proxy;

public class SubjectImpl implements Subject {

	@Override
	public String saySomething(String name,String age) {
	
		return "名字："+name+"  年龄："+age;
	}
	

}
