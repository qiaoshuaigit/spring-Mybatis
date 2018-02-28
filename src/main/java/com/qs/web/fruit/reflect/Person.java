package com.qs.web.fruit.reflect;

public class Person {
	public Person() {}
	public Person(String name,String telphone) {
		this.name=name;
		this.setTelphone(telphone);
	}
	private String name;
	private Integer sex;
	private String address;
	private String telphone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;		
	}
	
	public String sysGoodBye(String name) {
		return "GoodBye "+name;
	}

}
