package com.qs.web.fruit.apacheUtils;

import com.qs.web.fruit.model.User;
import org.apache.commons.betwixt.io.BeanWriter;
import org.xml.sax.SAXException;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaion 2018/2/11
 *
 * Bean转化为xml
 **/
public class BeanToXml {

    public static void main(String[] args) {
        StringWriter writer = new StringWriter();
        writer.write("<?xml version=’1.0′ encoding=’UTF-8′ ?>\n");
        BeanWriter beanWriter = new BeanWriter(writer);
        beanWriter.getXMLIntrospector().setAttributesForPrimitives(false);
        beanWriter.enablePrettyPrint();

        User user = new User();
        user.setUserName("特朗普");
        user.setTelephone("13990907878");
        user.setLoginName("总统先生");

        User user1 = new User();
        user1.setUserName("奥巴马");
        user1.setTelephone("13990907878");
        user1.setLoginName("前总统");

        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user1);

        try {
            beanWriter.write("users",users);
            writer.write("\n</xml>");
            System.out.println(writer.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }
}
