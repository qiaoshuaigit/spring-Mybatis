package com.qs.web.fruit.thread;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * 测试如何限制线程并发数量
 *
 * @author shuaion 2018/3/28
 **/
public class TestSemaphore {
    //最多允许1个线程同时执行
    private static Semaphore semaphore = new Semaphore(1);

    public static void study(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:"+Thread.currentThread().getName()+",time="+ new Date().getTime());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:"+Thread.currentThread().getName()+",time="+ new Date().getTime());

        semaphore.release();
    }


    static class Student extends Thread{

        @Override
        public void run() {
            study();
        }
    }



    public static void main(String[] args) {

        Thread a = new Student();
        a.start();

        Thread b = new Student();
        b.start();

        Thread c = new Student();
        c.start();

    }

}
