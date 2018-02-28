package com.qs.web.fruit.model;

import java.lang.reflect.Field;

/**
 * @author shuaion 2018/1/29
 **/
public class DataSet {

    private Object object;


    public DataSet(Object object) {
        this.object = object;
    }

    public void setData(){
        //返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段
        //Field[] fields = object.getClass().getFields();
        //返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0;i<fields.length;i++){
            Field field = fields[i];
            System.out.println("fieldName = "+field.getName());
            System.out.println("fieldName Type = "+field.getType().getName());
            field.setAccessible(true);
            if (field.getType().getName().equals("java.lang.String")){
                try {
                    field.set(object,"张三"+i);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else if(field.getType().getName().equals("java.lang.Integer")){
                try {
                    field.set(object,new Integer(10));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void setData1(Object object){
        try {
            Class<CarInfo> aClass = (Class<CarInfo>) Class.forName(object.getClass().getName());
            CarInfo carInfo = aClass.newInstance();
            carInfo.setName("aobama");
            carInfo.setPath("path");
            carInfo.setCarAge(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setData2(CarInfo carInfo){
        carInfo.setCarAge(20);
        carInfo.setName("lisi");
        carInfo.setPath("path");
    }


}
