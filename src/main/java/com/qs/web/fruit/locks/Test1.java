package com.qs.web.fruit.locks;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock Condition 实现生产者 消费者模式
 *
 * @author shuaion 2018/2/27
 **/
public class Test1 {

    //生产者 消费者共享对象
    private LinkedBlockingQueue queue = new LinkedBlockingQueue(10);
    private ReentrantLock lock = new ReentrantLock(true);

    //队列是否为空
    private Condition notEmpty = lock.newCondition();
    //队列是否已满
    private Condition notFull = lock.newCondition();


    class Customer implements Runnable {

        public void run() {
            lock.lock();
            try {
                while (true) {
                    if (queue.size() == 0) {
                        System.out.println(Thread.currentThread().getName()+"消费没了");
                        notEmpty.await();//消费者暂停
                        System.out.println("customer stop");
                    }else {
                        custome();//唤醒生产者
                        notFull.signal();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("消费者释放锁");
                lock.unlock();
            }
        }

        private void custome() {
            System.out.println("当前线程:"+Thread.currentThread().getName()+"消费之中,"+"剩余"+queue.size()+"个。");
            queue.poll();
        }
    }


    class Product implements Runnable {

        public void run() {
            lock.lock();
            try {
                while (true) {
                    if (queue.size() == 10) {
                        System.out.println(Thread.currentThread().getName()+"生产满了");
                        notFull.await();//生产者暂停
                        System.out.println("product stop");
                    }else {
                        product();//消费者唤醒
                        notEmpty.signal();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者释放放锁");
                lock.unlock();
            }
        }

        public void product() throws InterruptedException {
            System.out.println("当前线程:"+Thread.currentThread().getName()+"生产之中...,剩余"+queue.size()+"个。");
            queue.offer("1");
        }
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        Customer c = test.new Customer();
        Product p = test.new Product();

        Thread t1 = new Thread(c,"customer-1");
        Thread t2 = new Thread(c,"customer-2");
        Thread t3 = new Thread(p,"product-1");
        Thread t4 = new Thread(p,"product-2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("执行完毕");
        }

    }
}

