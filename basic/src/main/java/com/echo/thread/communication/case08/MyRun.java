package com.echo.thread.communication.case08;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/22 10:54
 * 项目名称: {JAVA-THREAD}
 * 文件名称: MyRun
 * 文件描述: [java-thread-wait&notify]
 * 				用于线程间通信
 * 				notify
 * 					如果提前通知，可能会打乱程序的正常逻辑
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class MyRun {

    private String lock = new String("");
    private boolean isFirstRunB = false;

    private Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (isFirstRunB == false) {
                        System.out.println("begin wait");
                        lock.wait();
                        System.out.println("end wait");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable runnableB = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("begin notify");
                lock.notify();
                System.out.println("end notify");
                isFirstRunB = true;

            }
        }
    };

    public static void main(String[] args) throws InterruptedException {

        MyRun run = new MyRun();
        Thread b = new Thread(run.runnableB);
        b.start();

        Thread.sleep(100);

        Thread a = new Thread(run.runnableA);
        a.start();
    }

}
