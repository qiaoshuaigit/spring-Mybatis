package com.qs.web.fruit.model;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author shuaion 2018/1/29
 **/
public class test {

    public static void main(String[] args) {
        /*CarInfo carInfo = new CarInfo();
        DataSet dataSet = new DataSet(carInfo);
        dataSet.setData();
        System.out.println("carinfo="+carInfo.toString());*/
        CarInfo carInfo = new CarInfo();
        DataSet dataSet = new DataSet(carInfo);
        dataSet.setData1(carInfo);//通过反射新建对象 所以此时carInfo仍然为空
        System.out.println("carinfo="+carInfo.toString());//carinfo=CarInfo{name='null', carAge=null, path='null'}
        dataSet.setData2(carInfo);//这个方法是在此carInfo对象上设置值 所以不为空
        System.out.println("carinfo="+carInfo.toString());

    }
}
