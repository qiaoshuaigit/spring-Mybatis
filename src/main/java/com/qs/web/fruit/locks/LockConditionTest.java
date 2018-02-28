package com.qs.web.fruit.locks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock与Condition实现生产消费模式
 * <p>
 * 为了更好的理解Lock和Condition的使用场景，下面我们先来实现这样一个功能：
 * 有多个生产者，多个消费者，一个产品容器，
 * 我们假设容器最多可以放3个产品，如果满了，生产者需要等待产品被消费，如果没有产品了，消费者需要等待。
 * 我们的目标是一共生产10个产品，最终消费10个产品。
 * <p>
 * 同步器AQS包含
 * 一个同步队列和多个等待队列
 *
 * @author shuaion 2018/2/28
 **/
public class LockConditionTest {
    //创建公平锁
    private static ReentrantLock lock = new ReentrantLock(false);

    private static Condition notEmpty = lock.newCondition();

    private static Condition notFull = lock.newCondition();

    private static final int continerSize = 3;//容器容纳最大个数

    private static final int totalCount = 10;//生产最大产品数
    //容器
    /**
     * 使用非同步容器 如LinkList 当使用非公平锁时 会造成消费时出现空指针异常 continer.removeFirst();
     * 虽然程序使用了锁
     */
    //private static LinkedList<Integer> continer = new LinkedList<Integer>();
    private static ArrayBlockingQueue<Integer> continer = new ArrayBlockingQueue<Integer>(10);

    private static volatile int hasCustomerCount = 0;//已经消费个数

    private static volatile int hasProductCount = 0;//已经生产个数
    //标志产品
    private static AtomicInteger p = new AtomicInteger(0);


    static class Customer implements Runnable {

        public void run() {
            while (true) {
                lock.lock();//抢到锁
                System.out.println(Thread.currentThread().getName() + "...lock.lock...");
                try {
                    //如果消费个数大于等于产品最大生产数量 则退出
                    if (hasCustomerCount >= totalCount) {
                        System.out.println("1.线程【" + Thread.currentThread().getName() + "】退出");
                        return;
                    }
                    //如果容器为空 则暂停消费
                    while (continer.isEmpty()) {
                        System.out.println("线程【" + Thread.currentThread().getName() + "】释放锁");
                        //如果C1 线程 执行到这里 此时该线程还会继续执行 还是该线程立刻停止执行(线程挂起)
                        //如果线程C1 执行await释放锁资源【此线程加入等待队列】 该线程挂起 其他线程【同步队列中得线程】争夺锁资源
                        //当线程c1 再次被唤醒 signal时 加入到同步队列中 当C1线程获取到锁时 程序从上次阻塞(调用await方法)后开始执行。
                        notEmpty.await(2, TimeUnit.SECONDS);//设置2秒的原因是防止线程一直处于等待状态。
                        //如果消费个数大于等于产品最大生产数量 则退出
                        if (hasCustomerCount >= totalCount) {
                            System.out.println("1.线程【" + Thread.currentThread().getName() + "】退出");
                            return;
                        }
                    }
                    //Integer c = continer.removeFirst();
                    Integer c = continer.take();
                    System.out.println("此时容器产品个数"+continer.size()+"个,线程【" + Thread.currentThread().getName() + "】消费产品" + c);
                    hasCustomerCount++;

                    notFull.signal();//通知生产

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "...lock.unlock...");
                    lock.unlock();
                }

            }
        }
    }


    static class Product implements Runnable {

        public void run() {

            while (true) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "...lock.lock...");
                try {
                    //如果容器满了 通知生产者暂停
                    while (continer.size() >= continerSize) {
                        System.out.println("线程【" + Thread.currentThread().getName() + "】释放锁");
                        notFull.await();
                        System.out.println("..线程【" + Thread.currentThread().getName() + "】释放锁..");
                    }
                    //如果生产个数大于等于生产最大数量 则停止生产
                    System.out.println("");
                    if (totalCount <= hasProductCount) {
                        System.out.println("1.线程【" + Thread.currentThread().getName() + "】退出");
                        return;
                    }
                    int product = p.incrementAndGet();
                    continer.add(product);
                    hasProductCount++;//已经生产数量+1

                    System.out.println("线程【" + Thread.currentThread().getName() + "】生产产品" + product);

                    notEmpty.signal();//通知消费者消费

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "...lock.unlock...");
                    lock.unlock();
                }

            }
        }
    }


    public static void main(String[] args) {
        Thread p1 = new Thread(new Product(), "p-1");
        Thread p2 = new Thread(new Product(), "p-2");
        Thread p3 = new Thread(new Product(), "p-3");

        Thread c1 = new Thread(new Customer(), "c-1");
        Thread c2 = new Thread(new Customer(), "c-2");
        Thread c3 = new Thread(new Customer(), "c-3");

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
        try {
            p1.join();
            p2.join();
            p3.join();
            c1.join();
            c2.join();
            c3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完毕");
    }

}
