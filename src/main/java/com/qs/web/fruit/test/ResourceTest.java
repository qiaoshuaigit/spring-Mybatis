package com.qs.web.fruit.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试国际化类 ResourceBundle
 * @author ASUS
 *
 */
public class ResourceTest {

	
	public static void test1() {
		ResourceBundle bundle = ResourceBundle.getBundle("com/qs/web/fruit/db");
		System.out.println(bundle.getString("utf"));
	}
	public static void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/qs/web/fruit/message.xml");
		MessageSource mess = (MessageSource)ac.getBean("resourceBundle");
		String source = mess.getMessage("utf", null, "没有", Locale.CHINA);
		System.out.println("------source-----"+source);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test2();

	}
	

}
