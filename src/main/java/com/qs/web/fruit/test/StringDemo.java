package com.qs.web.fruit.test;

import com.qs.web.fruit.model.Apple;

/**
 * @author shuaion 2018/1/16
 **/
public class StringDemo {

    static {
        System.out.println("here is static block!");
    }

    {
        System.out.println("here is common block!");
    }
    public static void main(String[] args) {
        int data = 10;
        fun(data);
        System.out.println(data);

        Apple apple = new Apple(1,"iphone6");
        change(apple);
        System.out.println(apple.getName());
       /* String a = "helloword";
        String b = "HELLOWORD";
        System.out.println(a.compareTo(b));*/
    }

    public static void change(Apple apple1){
        apple1.setName("iphone7");
    }
    public static void fun(int data){
        data = 20;
    }
}
