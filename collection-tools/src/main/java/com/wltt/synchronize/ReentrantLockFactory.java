package com.wltt.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: wlt
 * data: 2020/3/21
 * description:
 */
public class ReentrantLockFactory {

    private int num;

    Lock lock = new ReentrantLock();
    private boolean flag = false;
    Condition product_con = lock.newCondition();
    Condition consume_con = lock.newCondition();

    public void product(){
        lock.lock();
        try{
            while (flag){
                try {
                    product_con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num ++;
            flag = true;
            System.out.println("这是第"+num+"次生产,thread_id:" + Thread.currentThread());
            consume_con.signal();
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try{
            while (!flag){
                try {
                    consume_con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = false;
            System.out.println("这是第"+num+"次消费, thread_id:" + Thread.currentThread());
            product_con.signal();
        }finally {
            lock.unlock();
        }
    }

    /**
     * @decrition 生产者线程
     */
    static class Mutil_Producer implements Runnable {
        private ReentrantLockFactory r;

        Mutil_Producer(ReentrantLockFactory r) {
            this.r = r;
        }

        public void run() {
            while (true) {
                r.product();
            }
        }
    }

    /**
     * @decrition 消费者线程
     */
    static class Mutil_Consumer implements Runnable {
        private ReentrantLockFactory r;

        Mutil_Consumer(ReentrantLockFactory r) {
            this.r = r;
        }

        public void run() {
            while (true) {
                r.consume();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockFactory r = new ReentrantLockFactory();
        Mutil_Producer pro = new Mutil_Producer(r);
        Mutil_Consumer con = new Mutil_Consumer(r);

        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);

        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }

}
