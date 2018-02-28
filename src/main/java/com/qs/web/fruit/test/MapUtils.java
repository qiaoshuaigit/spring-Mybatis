/**
 * @filename:MapUtils.java
 * @createDate:2014-4-8
 * @author: Super.qiao
 * @updateauthor:
 * @updateDate: 
 */
package com.qs.web.fruit.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

/**@className: MapUtils.java
 * @Description:测试Map与javabean的转化
 * @author: Super.qiao
 */
public class MapUtils {
	
	@SuppressWarnings("rawtypes")
	public static Object convertMap(Class type,Map map) throws IntrospectionException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获取类属性 
		BeanInfo beanInfo = Introspector.getBeanInfo(type); 
		//创建bean
		Object  bean = type.newInstance();
		//给bean属性赋值
		PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();	
		for (int i = 0; i < properties.length; i++) {
			PropertyDescriptor pro = properties[i];
			String propertyName = pro.getName();
			if (map.containsKey(propertyName)) {
				Object value = map.get(propertyName);
				Object[] args = new Object[1];
				args[0]= value;
				pro.getWriteMethod().invoke(bean,args);
				
			}
		}
		return bean;
	}
	
	
	 @SuppressWarnings("rawtypes")  
	 public static Object convertMaps(Class type,Map map)
	            throws IntrospectionException, IllegalAccessException,
	            InstantiationException, InvocationTargetException {
	       
	        return null;
	    } 
	 
	 
	 public static void main(String[] args) {
		 
		Map<String, Object> map =  new HashMap<String, Object>();
		 
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> m =  new HashMap<String, Object>();
		map.put("id", 1);
		map.put("loginName", "ZS");
		map.put("userName", "zhangsan");
		map.put("password", "shuaige");
		map.put("telephone", "13478665537");
		list.add(map);
		Map<String, Object> map1 =  new HashMap<String, Object>();
		map1.put("id", 2);
		map1.put("loginName", "WU");
		map1.put("userName", "WANGWU");
		map1.put("password", "shuaige");
		map1.put("telephone", "110");
		list.add(map1);
		m.put("users", list);
		
		System.out.println(m);
		
		
		String users = "{users=[{id=1, userName=zhangsan, telephone=13478665537, password=shuaige, loginName=ZS}, {id=2, userName=WANGWU, telephone=110, password=shuaige, loginName=WU}]}";
		
		  String[][] countries = { { "United States", "New York" }, { "United Kingdom", "London" },
			        { "Netherland", "Amsterdam" }, { "Japan", "Tokyo" }, { "France", "Paris" } };

			    Map countryCapitals = ArrayUtils.toMap(countries);

			    System.out.println("Capital of Japan is " + countryCapitals.get("Japan"));
			    System.out.println("Capital of France is " + countryCapitals.get("France"));
			} 
		
	

}
