package com.ehco.p1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 当多个线程同时共享同一个全局变量做写的操作时候，可能会受到其他线程的干扰。
 * 解决办法三：ReentrantReadWriteLock
 */
public class Thread013 {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // 如果对个线程同时读该代码 读读共享
    public void read() {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + ",开始读取数据");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + ",结束读取数据");
        lock.readLock().unlock();
    }

    //  如果多个线程同时写的情况下 写写 互斥
    public void write() {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + ",开始写入数据");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + ",结束写入数据");
        lock.writeLock().unlock();
    }
    public static void main(String[] args) {
        Thread013 thread013 = new Thread013();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                thread013.read();
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                thread013.write();
            }).start();
        }

    }
}
