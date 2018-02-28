package com.qs.web.fruit.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 去掉重复值
 * @author ASUS
 *
 */
public class MapRepeatData {
	
	public static void repeatData() {
		
    List<String> list =new ArrayList<String>();
    list.add("1");
    list.add("1");
    list.add("aa");
    list.add("aa");
    list.add("bb");
    list.add("bb");
        System.out.println(list);
    
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        repeatData();
    }

}
