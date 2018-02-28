package com.qs.web.fruit.locks;

import net.sf.ehcache.Ehcache;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock Condition 实现生产者 消费者模式
 *
 * @author shuaion 2018/2/27
 **/
public class Test {

    //生产者 消费者共享对象
    private ArrayList list = new ArrayList();
    private Lock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    class Customer implements Runnable {

        public void run() {
            lock.lock();
            try {
                while (true) {
                    if (list.size() == 0) {
                        System.out.println("消费没了");
                        notEmpty.await();//暂停
                    }
                    custome();
                    notFull.signal();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void custome() {
            System.out.println("当前线程:"+Thread.currentThread().getName());
            list.remove(0);
        }
    }


    class Product implements Runnable {

        public void run() {
            lock.lock();
            try {
                while (true) {
                    if (list.size() == 10) {
                        System.out.println("生产满了");
                        notFull.await();
                    }
                    product();
                    notEmpty.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void product() throws InterruptedException {
            System.out.println("当前线程:"+Thread.currentThread().getName());
            list.add("1");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
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

    }
}
