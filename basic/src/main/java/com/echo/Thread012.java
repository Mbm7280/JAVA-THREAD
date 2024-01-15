package com.echo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 21:56
 * 项目名称: {EBlog}
 * 文件名称: Thread012
 * 文件描述: [Description]: 读写锁（ReadAndWriteLock）
 *      读读共享、写写互斥、读写互斥。
 *
 *      Lock与Synchronized锁的区别
 *      Synchronized属于java内置的关键字，而lock锁是基于aqs封装的一个锁的框架
 *      Synchronized当代码执行结束自动释放锁，而lock需要人工释放锁，相对于来说lock锁更加灵活。
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread012 {

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
        Thread012 myTask = new Thread012();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                myTask.read();
//            }).start();
//        }
//
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                myTask.write();
//            }).start();
//        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                myTask.read();
                myTask.write();
            }).start();
        }

    }

}
