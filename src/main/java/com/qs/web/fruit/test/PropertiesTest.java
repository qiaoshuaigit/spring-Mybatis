package com.qs.web.fruit.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试获取属性文件中的值
 * @author ASUS
 *
 */


public class PropertiesTest {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public static void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");  
		
		PropertiesTest pro = (PropertiesTest)context.getBean("properties");
		String username = pro.getUsername();
		System.out.println("--username--"+username);
	}
	
	public static void test2() throws Exception {
		File file =new File("d:/jdbc.properties");
		Properties properties = new Properties();
		InputStream inputStream = new FileInputStream(file);		
	    properties.load(inputStream);
		System.out.println("==utf==="+properties.get("sqlserver.url"));
	}

	public static void main(String[] args) {
		
	try {
		test1();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
