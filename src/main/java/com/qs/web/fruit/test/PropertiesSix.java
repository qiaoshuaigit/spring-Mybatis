package com.qs.web.fruit.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * J2EE读取属性文件六种方法
 * @author shuai
 *
 */
public class PropertiesSix {

	
	public static void pro1() {
		
		InputStream in;
		try {
			//in = new BufferedInputStream(new FileInputStream(new File("d:/jdbc.properties")));
			in = new FileInputStream(new File("d:/jdbc.properties"));
			Properties properties = new Properties();
			properties.load(in);
			String url = properties.get("sqlserver.url").toString();
			System.out.println("第一种方法获取url："+url);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	public static void pro2() {
		//ResourceBundle默认找的是WEB-INF下class文件下的文件  有时间看看源码
		Locale locale = new Locale("zh", "CN"); 
		ResourceBundle resourceBundle = ResourceBundle.getBundle("config",/*locale*/Locale.getDefault());
		String rmURL = resourceBundle.getObject("rmURL").toString();
		System.out.println("第二种方法获取rmURL："+rmURL);
	}
	public static void pro3() {
		//以/开头代表从ClassPath（web-inf下class文件下）根下获取文件
		//InputStream in = PropertiesSix.class.getResourceAsStream("/config.properties");
		//不以/开头的则是代表从此类所在的包下取资源
		InputStream in = PropertiesSix.class.getResourceAsStream("db_1.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			String res = (String) properties.get("utf");
			System.out.println("第三种方法获取utf："+res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void pro4() {
		//此方法默认加载ClassPath路径下 默认则是从ClassPath根下获取
		InputStream in = PropertiesSix.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			String res = properties.get("baseURL").toString();
			System.out.println("第四种方法获取baseURL："+res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void pro5() {
		//java.lang.ClassLoader的静态方法getSystemResourceAsStream
		InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
		Properties properties=new Properties();
		try {
			properties.load(in);
			String res = properties.get("baseURL").toString();
			System.out.println("第五种方法获取baseURL："+res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void pro6() {
		try {
			ResourceBundle resourceBundle = new PropertyResourceBundle(new FileInputStream(new File("d:/jdbc.properties")));					
			String res = resourceBundle.getObject("sqlserver.password").toString();
			System.out.println("第六种方法获取sqlserver.password："+res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		pro6();

	}

}
