package com.echo.thread.communication.case06;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/22 10:45
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Test
 * 文件描述: [java-thread-wait&notify]
 * 				用于线程间通信
 * 				notifyAll:
 * 					当有多个线程处于 wait 等待状态时，调用 notifyAll 方法将唤醒所有处于 wait 方法的线程
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        ThreadB b = new ThreadB(lock);
        b.start();

        ThreadC c = new ThreadC(lock);
        c.start();

        Thread.sleep(1000);

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();

    }

}
