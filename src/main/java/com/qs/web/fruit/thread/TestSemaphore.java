package com.qs.web.fruit.thread;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * 测试如何限制线程并发数量
 *
 * 来自java并发编程 核心方法与框架
 *
 * 此类不保证线程得安全性
 *
 * @author shuaion 2018/3/28
 **/
public class TestSemaphore {

    //最多允许2个线程同时执行 ture 代表公平竞争模式 先进先出FIFO
    private static Semaphore semaphore = new Semaphore(10,true);

    public static void study(){
        try {
            semaphore.acquire(5);//从该信号量获取给定数量的许可证，阻止直到所有可用，否则线程为interrupted  10/5=2 每次允许2个线程通过
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:"+Thread.currentThread().getName()+",begin time="+ new Date().getTime());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:"+Thread.currentThread().getName()+",end time="+ new Date().getTime());

        semaphore.release(5);//释放信号灯 +1
    }


    static class Student extends Thread{

        @Override
        public void run() {
            study();
        }
    }


    

    public static void main(String[] args) {

        Student[] students = new Student[10];
        for (int i=0;i<students.length;i++){
            students[i] = new Student();
            students[i].start();
        }

    }

}
