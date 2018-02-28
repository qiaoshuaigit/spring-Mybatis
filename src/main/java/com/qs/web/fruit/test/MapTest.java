package com.qs.web.fruit.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	/**
	 * 将Map里的值输出
	 * 1.Map是key-value形式的集合，collection、set、list是单值操作的集合
	 */
	public static void shuChuMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1","第1名");
		map.put("2","第2名");
		map.put("3","第3名");
        /*输出map步骤
         * 1.将Map转化为集合（Entry:Map值保存在此接口实例中）
         * 2.然后迭代输出
         * */
		Set<Entry<String, String>> entrySet=map.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println("----entry集合---"+entry);
			System.out.println("----entry的key---"+entry.getKey());
			System.out.println("----entry的value---"+entry.getValue());
			
		}
		
	}
	public void test1() {
//		String json = "{\"result\":{\"BJ\":{\"province\":\"北京\",\"citys\":[{\"city_name\":\"北京\",\"city_code\":\"BJ\",\"abbr\":\"京\",\"engine\":\"1\",\"engineno\":\"0\",\"cjha\":\"0\",\"cjh\":\"0\",\"cjhno\":\"0\",\"regist\":\"0\",\"registno\":\"0\"}]}},\"resultcode\":\"200\",\"reason\":\"成功的返回\"}";
		Map<String, String> map = new HashMap<String, String>();
		map.put("1","第1名");
		map.put("2","第2名");
		map.put("3","第3名");
		map.put("第4名","4");
		map.put("第5名","5");
		Set<String> set =  map.keySet();
		Iterator<String> iterator =set.iterator();
		while (iterator.hasNext()) {
			System.out.println("--遍历出key--"+iterator.next());
		}
		/**/
		Set<Entry<String, String>> set2 = map.entrySet();
		Iterator<Entry<String, String>> iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			/*System.out.println("----<Entry<String, String>---"+iterator2.next());*/
			System.out.println("----<Entry<String, String>-getKey()---"+iterator2.next().getValue());

		}
		

	}
	public static void main(String[] args) {
		shuChuMap();
		
	}

	
}
