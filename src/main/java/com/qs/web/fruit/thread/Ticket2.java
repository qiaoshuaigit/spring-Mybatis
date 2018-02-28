package com.qs.web.fruit.thread;

/**
 * @author shuaion 2018/1/21
 **/
public class Ticket2 implements Runnable {

    private int ticket = 6;

    public synchronized void sale() {
        for (int i = 0; i < 10; i++) {
            if (this.ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("線程名稱:" + Thread.currentThread().getName() + ",当前剩余票数是:" + this.ticket--);
            }
        }
    }

    public void run() {
        sale();
    }

    public static void main(String[] args) {
        Ticket2 t = new Ticket2();
        //此段代码共启动得2个线程共享6个票 一直都是A线程先执行
        //new Thread(t, "線程A").start();//启动线程
        //new Thread(t, "線程B").start();//启动线程
        //此段代码启动得2个线程 每个线程个6涨票 cd线程交替执行
        new Thread(new Ticket2(), "線程c").start();
        new Thread(new Ticket2(), "線程d").start();

    }
}
