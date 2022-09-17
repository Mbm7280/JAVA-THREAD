package com.ehco.p1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread012  implements Runnable {

    private static int count = 100;

    private Lock lock = new ReentrantLock();


    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    public void ticket() {
        try {
            Thread.sleep(30);
        } catch (Exception e) {

        }
        try {
            // 获取锁
            lock.lock();
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",正在出票第" + (100 - count + 1) + "张");
                count--;
            }
        } catch (Exception e) {

        } finally {
            // 释放锁
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Thread012 thread012 = new Thread012();
        new Thread(thread012, "窗口1").start();
        new Thread(thread012, "窗口2").start();
    }

}
