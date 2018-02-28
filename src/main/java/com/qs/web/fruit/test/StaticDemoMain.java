package com.qs.web.fruit.test;


/**
 * 静态代码块
 * @author ASUS
 *
 */
public class StaticDemoMain {
	
	
	public static void main(String[] args) {
		StaticDemo staticDemo = StaticDemo.getInstance();
		staticDemo.setName("zhangsan");
		StaticDemo staticDemo1 = StaticDemo.getInstance();
		staticDemo1.setName("lisi");
		/*为什么输出的结果是最后一次赋予的值"lisi"呢？
		 * 因为他们的都指向的是一个地址
		 * 为什么指向一个地址呢?
		 * 因为通过getInstance得到的是一个静态的实例（静态属性也称类属性，是多对象共享的、公共的属性）
		 * */
		System.out.println("staticDemo:"+staticDemo.getName());
		System.out.println("staticDemo1:"+staticDemo1.getName());
		
	}

}
