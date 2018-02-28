package com.qs.web.fruit.test;


/**
 * 静态代码块
 * @author ASUS
 *
 */
public class StaticDemo {
	private String name;
	private String address;
	
	/*java存在4个内存空间
	 * 1.栈内存空间：保存所有的对象的名称 即更确切的说保存了引用堆内存空间的地址
	 * 2.堆内存空间：保存每个对象的具体属性内容
	 * 3.全局数据区：或称为静态数据区  保存static类型的属性
	 * 4.全局代码区：保存所有的方法定义
	 * */
	
	
	/*=====第二种解释================
	 * 来自http://blog.csdn.net/a859522265/article/details/7282817
	 * java中内存主要包含4块，即heap(堆内存)、stack(栈内存)、data segment(静态变量或是常量存放区)、
	 * codesegment(方法区). 
		堆内存中存放的是new出的对象，new出的对象只包含成员变量。 
		栈内存中：存放的是局部成员变量。对于基本的数据类型存放的是基本变量的值，而对于对象变量，
		存放的是堆内存的地址。 
		静态、常量区：存放的是静态变量(类变量)或是常量。 
		方法区：存放的是对象的方法。因此即使new出多个对象也是只是存在一个方法。 
		
		如 
		A a = new A(); A中含有一个work方法，2个成员变量a,b。那么对应的内存分配为 
		则 a是分配在栈内存中。里面存放了一个指向堆内存中存放的new A()的地址。 
		new A()会导致在堆内存中分配一块空间，该内存中的A对象同时会含有a和b。 
		work()方法会在codesegment区中分配内存。 
		如果此时 A b = a;则表示把a的值复制给b，即b的值为a中保存的地址
	 * 
	 * 由此我们可以知道反射的基础：

		在装载类的时候，加入方法区中的所有信息，最后都会形成Class类的实例，代表这个被装载的类。
		方法区中的所有的信息，都是可以通过这个Class类对象反射得到。我们知道对象是类的实例，
		类是相同结构的对象的一种抽象。同类的各个对象之间，其实是拥有相同的结构（属性），
		拥有相同的功能（方法），各个对象的区别只在于属性值的不同。
		 同样的，我们所有的类，其实都是Class类的实例，他们都拥有相同的结构-----Field数组、
		 Method数组。而各个类中的属性都是Field属性的一个具体属性值，方法都是Method属性的一个具体属性值。
	 * */

	private static StaticDemo staticDemo=new StaticDemo();//封装的静态属性或称为全局属性
	
	private StaticDemo(){};//将构造方法封装（就是私有化，即不对外暴露，而是通过方法向外暴露）
	
	public static StaticDemo getInstance() {//对外提供静态实例化对象方法
		return staticDemo;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
