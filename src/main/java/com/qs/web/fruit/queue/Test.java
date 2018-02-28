package com.qs.web.fruit.queue;

import com.qs.web.fruit.model.User;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 队列测试
 *
 * @author shuaion 2018/2/12
 **/
public class Test {

    private static ArrayBlockingQueue<User> queue = new ArrayBlockingQueue<User>(1);

    private static AtomicInteger index = new AtomicInteger(1);

    public Test(){}

    public Test(ArrayBlockingQueue<User> queue) {
        this.queue = queue;
    }

    /**消费者**/
    class Customer implements Runnable{

        public void run() {
            try {
                while (index.intValue()<10){
                    //如果队列中 没有元素 则一直阻塞 直到有元素
                    User user = queue.take();
                    if (user==null){
                        System.out.println("user为空");
                    }else {
                        System.out.println("消费user="+user.toString());
                        index.incrementAndGet();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
/**生产者**/
    class Product implements Runnable{

        public void run() {
            try {
                Thread.sleep(5000);
                for (int i=0;i<10;i++){
                    Thread.sleep(3000);
                    User user = new User("zhangsan"+i,"1508888000"+i);
                    System.out.println("添加user:"+user.toString());
                    try {
                        queue.put(user);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(test.new Customer());
        Thread t2 = new Thread(test.new Product());

        t1.start();
        t2.start();

    }
}
