package com.qs.web.fruit.test;


/**
 * 静态代码块
 * @author ASUS
 *
 */
public class StaticDemo2 {
	/*非static声明的方法可以方位静态的属性（当然了，非static的属于对象范畴，对象当然可以访问全局属性了）
	 * 而static方法不可以访问到非static声明的方法
	 * 这一点不难理解，因为程序中的所有非static属性和方法在对象开辟堆内存之后才可以调用，
	 * 而static方法在对象未被实例化时就可以调用，static调用非static方法，则属性还没有被初始化
	 * 
	 * 在StaticDemo1例子中就可以看出来
	 * 静态代码块先于构造代码块执行
	 * */
	
	private static String name="zhangsan";
	private String address="北京";
	
	public static void fun() {
		/*System.out.println(address);这里报错*/
		/*fun1();  这里报错*/
	}
	public void fun1() {
		System.out.println("name="+name);
	}
}
