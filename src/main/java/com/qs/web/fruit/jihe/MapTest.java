package com.qs.web.fruit.jihe;

import com.qs.web.fruit.model.Apple;
import com.qs.web.fruit.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuaion 2018/1/31
 **/
public class MapTest {

    public static void main(String[] args) {
        Map<Object,Object> map = new HashMap<Object, Object>();
        User user = new User();
        user.setId(10);
        user.setUserName("zhangsan");
        map.put(user,user);
        System.out.println(map.get(user));
        user.setId(13);
        user.setUserName("wangwu");
        user.setTelephone("110");
        System.out.println(map.get(user));

    }
}
