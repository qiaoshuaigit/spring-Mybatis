package com.qs.web.fruit.thread;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

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
public class TestCycliBarrier implements Runnable{

    //定义4个屏障 处理完之后 执行当前类得run方法
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);
    //定义线程池
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    //保存每个sheet得结果
    private static ConcurrentHashMap<String,Integer> sheetsResult = new ConcurrentHashMap<String, Integer>();

    //计算每个sheet方法
    private void count(){
        for (int i=0;i<4;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //放入计算得每个sheet得结果集
                    sheetsResult.put(Thread.currentThread().getName(),2);
                    try {
                        //计算完一个 插入一个屏障 等到达所定义得个数时 执行 所传入线程得方法。
                        System.out.println("第一先执行");
                        cyclicBarrier.await();
                        System.out.println("第三先执行");
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

    @Override
    public void run() {
        int result = 0;
        Set<Map.Entry<String, Integer>> sets = sheetsResult.entrySet();
        Iterator<Map.Entry<String, Integer>> its = sets.iterator();
        while (its.hasNext()){
           result += its.next().getValue();
        }

        System.out.println("第二先执行,最后计算结果:"+result);

    }


    public static void main(String[] args) {
        TestCycliBarrier testCycliBarrier = new TestCycliBarrier();
        testCycliBarrier.count();
    }
}
