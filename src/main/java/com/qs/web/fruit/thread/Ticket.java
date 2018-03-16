package com.qs.web.fruit.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shuaion 2018/1/21
 *
 * ①每个线程都有一个自己的本地内存空间--线程栈空间 ，
 * 每个线程执行时，先把变量从主内存读取到线程自己的本地内存空间，然后再对该变量进行操作。
   ②对该变量操作完后，在某个时间再把变量刷新回主内存
 *
 * volatitle不保证一致性
 * 1.volatitle保证修饰得变量 对其他线程立即可见 就是不允许将此变量同步到线程内存中
 * 2.禁止指令重新排序
 *
 *
 **/
public class Ticket extends Thread {

    private static AtomicInteger ticket1 = new AtomicInteger(20);

    private static volatile int ticket = 10;

    public synchronized void buyTick(){
        while (ticket>0){
            //不是原子操作
            ticket = ticket - 1;
            System.out.println(Thread.currentThread().getName()+" 购票成功:"+ticket);
        }
    }
    public synchronized void buyTick1(){
        //原子操作
        while (ticket1.decrementAndGet()>0){
            //打印出来得值 仍然有问题 原因可能是
            // ticket1执行完decrementAndGet之后值没有立即刷到主内存 导致下一个线程获取值不正确
            System.out.println(Thread.currentThread().getName()+" 购票成功1:"+ticket1.get());
        }
    }

    public void run() {
       // if (ticket>0){
            buyTick1();
        //}

    }

    public static void main(String[] args) throws InterruptedException {
        Ticket t = new Ticket();
        //此段代码共启动得2个线程共享6个票 一直都是A线程先执行
       /*Thread t3 = new Thread(t, "線程A");//启动线程
       Thread t4 = new Thread(t, "線程B");//启动线程
       Thread t5 = new Thread(t, "線程C");//启动线程
        t3.start();
        t4.start();
        t5.start();
        t5.join();*/


        Ticket[] ts = new Ticket[10];
        for (int i = 0;i<ts.length;i++){
            ts[i] = new Ticket();
            ts[i].start();
        }


        /*Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Ticket ticket3 = new Ticket();
        ticket1.start();
        ticket2.start();
        ticket3.start();*/


        try {
            //t4.join();
            //t3.join();
            //此段代码也有可能在循环过程中打印,因为一共四个线程包括主线程 去争取CPU资源。
            System.out.println("------here-----");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //此段代码启动得2个线程 每个线程个6涨票 cd线程交替执行
       /*Thread t1 = new Thread(new Ticket(), "線程c");
       Thread t2 =  new Thread(new Ticket(), "線程d");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
