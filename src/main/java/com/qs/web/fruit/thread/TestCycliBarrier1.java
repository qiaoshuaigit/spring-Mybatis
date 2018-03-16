package com.qs.web.fruit.thread;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试CycliBarrier 循环栅栏【屏障】
 *
 * @author shuaion 2018/3/16
 *
 * 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。
 * 在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。
 * 因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。
 *
 *
 * 需求:统计一个excel表,每个sheet保存一个账户近一年得银行流水
 * 最后统计整个excel所有流水和
 *
 **/
public class TestCycliBarrier1{

    //定义4个屏障 处理完之后 执行当前类得run方法
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4,new Pruduct());
    //定义线程池
    private static ExecutorService executor = Executors.newFixedThreadPool(4);
    //保存每个sheet得结果
    private static volatile int res = 0;
    //private static AtomicInteger res = new AtomicInteger(0);

    static class Pruduct implements Runnable{

        @Override
        public void run() {
            System.out.println("最终结果:"+res);
        }
    }



    public static void main(String[] args) {
        System.out.println("开始...");
        for (int i=0;i<4;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    res=res+10;
                    //res.incrementAndGet();
                    try {
                        System.out.println("第一个执行"+Thread.currentThread().getName());
                        cyclicBarrier.await();//当设定个数得线程到达屏障之后 开始执行给定得线程任务。之后再从这里开始执行
                        System.out.println("第三个执行"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();
    }
}
