package com.qs.web.fruit.fanxing;
/*
 * 1.泛型可以解决数据类型安全问题（如防止出现java.lang.ClassCastException 类型转化问题）
 * 2.泛型是由对象实例化时外部决定的
 * 所谓的泛型是指在对象建立的时候不指定类中属性的类型，而是由外部在声明及实例化对象时指定具体类型
 * 
 * */
public class Persion <T>{

	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	/*虽然2处 persion泛型为Object 在方法fun指定String类型 String为Object的子类  但是也无法操作*/
	static void fun(/*2.Persion<Object>*/Persion<String> persion){
		
		System.out.println("----here--is---fun--"+persion.getVar());
	}
	static void fun1(Persion<?> persion){
		System.out.println("---------here------"+persion.getVar());
	}
	public static void main(String[] args) {
		Persion<String> persion=new Persion<String>();
		/*1
		persion.setVar("zhangsan");
		System.out.println(persion.getVar());*/
		
		/*2
		  persion.setVar("zhangsan");
		  persion.fun(persion);*/
		
		/*Persion<?> persion1=new Persion<Object>();
			persion1.setVar(null);//如果为通配符 则不能设置泛型类型内容
			persion1.fun1(persion);*/
		
	}
}
