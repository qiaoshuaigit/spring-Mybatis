package com.qs.web.fruit.test;


/**
 * 静态代码块
 * @author ASUS
 *
 */
public class StaticDemo1 {
	
	public StaticDemo1() {
		System.out.println("构造代码块");
	}	
	
	{
		System.out.println("普通代码块");
	}
	static{
		System.out.println("静态代码块");
	}
	
	
	public static void main(String[] args) {
		/*
		 * 从执行的结果来看 静态代码块先于主方法执行
		 * 即 静态代码块--》主方法==》普通代码块==》构造代码块
		 * 而且静态代码块只执行一次（因为静态代码块是全局属性 在static内存区）
		 * */
		System.out.println("----主方法开始执行-----");
		new StaticDemo1();
		new StaticDemo1();
		new StaticDemo1();
		
	}
	
	
}
