package com.qs.web.fruit.proxy;
/***
 * 动态代理
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/*聚合*/
/* Invocation调用
 * Handle处理
 * */
/**
 * 
 * @author 在MyInvocationHandle这里添加自己的逻辑
 *
 */
public class MyInvocationHandle implements InvocationHandler {

	private Object obj;//被代理的对象、值 来自构造方法
	public Object bind(Object obj1) {//通过构造方法把被代理对象添加进来
		this.obj=obj1;
		Object oo=Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		return oo;
	}


	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("此处加上自己的逻辑，如spring的事物处理");
		Object temp=method.invoke(this.obj, args);
		return temp;
	}

}
