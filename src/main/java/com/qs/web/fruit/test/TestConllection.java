package com.qs.web.fruit.test;

import java.util.*;

/**
 * @author shuaion 2018/1/30
 **/
public class TestConllection {

    public static void test1(){
        HashSet set = new HashSet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("zhangsan");
        set.add("lisi");
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

    public static void test2(){
        //MAP接口:某些映射实现可明确保证其顺序，如 TreeMap 类；另一些映射实现则不保证顺序，如 HashMap 类
        //将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值。
        HashMap map = new HashMap();
        map.put("zhangsan","12");
        map.put("lisi","23");
        map.put("zhaoliu","43");
        map.put("zhaoliu","232");
        map.put("wangwu","44");

        Set keys = map.keySet();
        Iterator key = keys.iterator();
        while (key.hasNext()){
            System.out.println(key.next());
        }

        System.out.println("map="+map);
    }
    public static void main(String[] args) {
        //test1();
        test2();
    }
}
