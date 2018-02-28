package com.qs.web.fruit.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射机制练习
 * 
 * @author ASUS
 * 
 */
public class ReflectDemo {

	public static void demo1() {
		try {
			Class<?> c = Class.forName("com.qs.web.fruit.reflect.Person");
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void demo2() {

		Class<?> c;
		try {
			c = Class.forName("com.qs.web.fruit.reflect.Person");
			Person person = (Person) c.newInstance();
			System.out.println(person.sysGoodBye("zhangsan"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void demo3() {
		try {
			Class<?> c = Class.forName("com.qs.web.fruit.reflect.Person");
			/*获取本类属性集合*/
			Field[] fields = c.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				/*属性修饰符*/
				String modifiers = Modifier.toString(fields[i].getModifiers());
				System.out.print(modifiers+" ");
				String typeName=fields[i].getType().getName();
				System.out.print(typeName+" ");
				System.out.print(fields[i].getName()+";");
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 还原方法
	 */
	public static void demo4() {
		try {
			Class<?> p = Class.forName("com.qs.web.fruit.reflect.Person");
			Method[] m = p.getMethods();
			/*方法一：取得全部方法*/
			for (int i = 0; i < m.length; i++) {
				/*获取方法修饰符为int类型*/
				int mod = m[i].getModifiers();
				/*将方法修饰符类型转化为String类型*/
				String modifer = Modifier.toString(mod);
				/*获取方法返回值类型*/
				Class<?> returnType = m[i].getReturnType();
				String returnName = returnType.getName();
				/*获取方法名称*/
				String methodName = m[i].getName();
				System.out.print(modifer + " ");
				System.out.print(returnName + " ");
				System.out.print(methodName + " "+"(");
				/*获取方法参数类型*/
				Class<?>[] paramTypeClass=m[i].getParameterTypes();
				for (int j = 0; j < paramTypeClass.length; j++) {
					System.out.print(paramTypeClass[j].getName()+" "+"arg"+j);
					if (paramTypeClass.length-1>j) {
						System.out.print(",");
					}
				}
				System.out.print("){");				
				System.out.print("}");
				System.out.println();
			}
			
			/*方法二：取得全部方法
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i]);
			}*/

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*获取类中构造方法*/
	public static void demo5() {
		try {
			Class<?> cc=Class.forName("com.qs.web.fruit.reflect.Person");
			Constructor<?>[] cons=cc.getConstructors();
			for (int i = 0; i < cons.length; i++) {
				/* 方法一：输出全部构造方法
				System.out.println(cons[i]);*/
				/* 方法二：输出全部构造方法*/
				System.out.print(Modifier.toString(cons[i].getModifiers())+" "); 
				System.out.print(cons[i].getName());
				Class<?>[] paramType = cons[i].getParameterTypes();
				System.out.print("(");
				for (int j = 0; j < paramType.length; j++) {
					System.out.print(paramType[j].getName()+" arg"+j);
					if (paramType.length-1>j) {
						System.out.print(",");
					}					
				}
				System.out.print(")");
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/***
	 * 通过反射调用类中的方法
	 */
	public static void demo6() {
		try {
			Class<?> c=Class.forName("com.qs.web.fruit.reflect.Person");
			Object object=c.newInstance();
			
			Method method=c.getMethod("sysGoodBye", String.class);
			Object result=method.invoke(object, "张三");
			System.out.println("方法返回的结果："+result);
			
			Method method1=c.getMethod("setTelphone", String.class);
			Object result1=method1.invoke(object, "15882445811");
			System.out.println("方法返回的结果："+result1);
			
			Method method2=c.getMethod("getTelphone");
			Object result2=method2.invoke(object);
			System.out.println("方法返回的结果："+result2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/***
	 * 通过反射操作类中的属性
	 */
	public static void demo7() {
		try {
			Class<?> c=Class.forName("com.qs.web.fruit.reflect.Person");
			Object object=c.newInstance();
			Field name = c.getDeclaredField("name");
			name.setAccessible(true);
			name.set(object, "王老六");
			System.out.println(name.get(object));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	/***
	 * 动态代理
	 */
	public static void demo8() {}
	public static void main(String[] args) {
		/*
		 * demo1(); demo2(); demo4();
		 demo3();demo5();*/demo6();
		
	}

}
