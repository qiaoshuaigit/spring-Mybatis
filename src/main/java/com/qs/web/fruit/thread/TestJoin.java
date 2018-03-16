package com.qs.web.fruit.thread;

/**
 * Thread join方法demo
 *
 * tt.join() 强制tt线程执行,当前线程进入阻塞状态,其他线程无法执行,直到tt线程执行完毕 当前线程【阻塞线程】才可以执行
 *
 * @author shuaion 2018/3/15
 **/
public class TestJoin {

    static class Customer1 extends Thread {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("START 线程:"+name);
            for (int i = 0;i<5;i++){
                System.out.println(name+" i="+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("END 线程:"+name);
        }
    }

    static class Customer2 extends Thread{

        public Customer1 customer1;

        public Customer2(Customer1 customer1){
            this.customer1 = customer1;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("START 线程 customer1.JOIN :"+name);
            try {
                customer1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("END 线程 customer1.JOIN: "+name);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Customer1 c1 = new Customer1();
        c1.setName("Thread1");
        Customer2 c2 = new Customer2(c1);
        c1.setName("Thread2");
        System.out.println(Thread.currentThread().getName()+"运行start!");
        c1.start();
        Thread.sleep(2000);
        c2.start();
        System.out.println("start c2.join....");
        c2.join();
        System.out.println("end c2.join....");
        System.out.println(Thread.currentThread().getName()+"运行end!");
    }

}
