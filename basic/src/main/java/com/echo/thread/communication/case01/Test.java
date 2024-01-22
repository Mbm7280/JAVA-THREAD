package com.echo.thread.communication.case01;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/22 10:03
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Test
 * 文件描述: [java-thread-wait&notify]
 * 				用于线程间通信
 * 				wait:
 * 					使当前执行的线程进行等待，由就绪状态进入等入状态
 * 					调用前需要获取该对象的对象锁（也就是要在同步方法或同步代码块中使用）
 * 					一个线程获取对象锁的wait线程运行完毕后，将会释放该对象锁
 * 					但此时如果该对象没有再次使用notify语句，则即使该对象已经空闲
 * 					其他wait状态等待的线程由于没有得到该对象的通知，还会继续堵塞在wait状态
 * 					直到这个对象发出一个notify或notifyall
 *
 * 				notify:
 * 					唤醒当前堵塞的线程,使其进入就绪状态
 *					调用前需要获取该对象的对象锁（也就是要在同步方法或同步代码块中使用）
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Test {
    public static void main(String[] args) {
        try {
            Object lock = new Object();

            MyThread1 t1 = new MyThread1(lock);
            t1.start();

            Thread.sleep(3000);

            MyThread2 t2 = new MyThread2(lock);
            t2.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
