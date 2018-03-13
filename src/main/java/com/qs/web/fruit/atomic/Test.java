package com.qs.web.fruit.atomic;

import com.qs.web.fruit.model.User;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 测试jdk原子操作包下得类
 *
 * @author shuaion 2018/3/12
 **/
public class Test {


    public static void t1() {
        User user = new User();
        user.setLoginName("telangpu");
        user.setUserName("特朗普");

        AtomicReference<User> referenceUser = new AtomicReference<User>(user);

        User user1 = new User();
        user1.setLoginName("telangpu");
        user1.setUserName("特朗普");
        user1.setTelephone("1592201212");
        user1.setLoginName("telangpu1");

        User updateUser = new User();
        updateUser.setLoginName("jinzhengen");
        updateUser.setUserName("金正恩");
        updateUser.setId(100);

        User newUser = referenceUser.getAndSet(updateUser);

        System.out.println("返回结果:"+newUser);
        System.out.println("返回结果:"+referenceUser.get());

        System.out.println("user={"+user.toString()+"}");

        System.out.println("referenceUser={"+referenceUser.toString()+"}");

        System.out.println("updateUser={"+updateUser.toString()+"}");


    }


    public static void main(String[] args) {
        t1();

    }
}
