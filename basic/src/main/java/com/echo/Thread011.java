package com.echo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 21:50
 * 项目名称: {EBlog}
 * 文件名称: Thread011
 * 文件描述: [Description]: ReentrantLock 重入锁
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread011 implements Runnable{

    private static int count = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    public void ticket() {
        // 获取锁
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
        Thread007 thread007 = new Thread007();
        new Thread(thread007, "窗口1").start();
        new Thread(thread007, "窗口2").start();
    }

}
