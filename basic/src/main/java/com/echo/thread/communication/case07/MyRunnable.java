package com.echo.thread.communication.case07;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/22 10:49
 * 项目名称: {JAVA-THREAD}
 * 文件名称: MyRunnable
 * 文件描述: [java-thread-wait&notify]
 * 				用于线程间通信
 * 				wait(long):
 * 					当线程处于 wait 等待状态时，可以根据设定的时间自动唤醒
 * 					也可由 notify/notifyAll 方法唤醒
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/

public class MyRunnable {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin timer="
                            + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait   end timer="
                            + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    static private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify begin timer="
                        + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify   end timer="
                        + System.currentTimeMillis());
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1);
        t1.start();
        Thread.sleep(3000);
        Thread t2 = new Thread(runnable2);
        t2.start();
    }

}
