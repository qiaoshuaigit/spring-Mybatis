package com.qs.web.fruit.test;

import java.util.Map;


/**
 * json转化为MAP
 * @author ASUS
 *
 */
public class JsonToMap {
	
	public static Map parserToMap(String s){  
		   /* Map map=new HashMap();  
		    JSONObject json=JSONObject.fromObject(s);  
		    Iterator keys=json.keys();  
		    while(keys.hasNext()){  
		        String key=(String) keys.next();  
		        String value=json.get(key).toString();  
		        if(value.startsWith("{")&&value.endsWith("}")){  
		            map.put(key, parserToMap(value));  
		        }else{  
		            map.put(key, value);  
		        }  		  
		    }  
		    return map;  */
		return null;
		} 

public static void main(String[] args) {
	String s = "{\"result\":\"123\"}";
	Map<String, Object> map = JsonToMap.parserToMap(s);
	System.out.println(map);
}
}
