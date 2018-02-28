package com.qs.web.fruit.thread;

/**
 * @author shuaion 2018/1/21
 **/
public class Ticket3 implements Runnable {

    private Boolean flag = false;

    private int ticket = 6;


    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (flag) {
                if (flag) {
                    System.out.println("个数:"+Thread.activeCount());
                    if (this.ticket > 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("線程名稱:" + Thread.currentThread().getName() + ",当前剩余票数是:" + this.ticket--);
                    }
                } else {
                    flag = true;
                    System.out.println("線程名稱-->:" + Thread.currentThread().getName() + ",当前剩余票数是:" + this.ticket);
                    continue;
                }

            }

        }

    }

    public static void main(String[] args) {
        Ticket3 t = new Ticket3();
        //此段代码共启动得2个线程共享6个票 一直都是A线程先执行
        //new Thread(t, "線程A").start();//启动线程
        // new Thread(t, "線程B").start();//启动线程
        //此段代码启动得2个线程 每个线程个6涨票 cd线程交替执行
        Thread thread = new Thread(t, "線程c");
        System.out.println(thread.getThreadGroup().getName());
        thread.start();
        Thread thread1 = new Thread(t, "線程d");
        System.out.println(thread1.getThreadGroup().getName());
        thread1.start();
    }
}
