package com.echo.thread.communication.case04;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/22 10:26
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Test
 * 文件描述: [java-thread-wait&notify]
 * 				用于线程间通信
 * 				wait:
 * 					当线程处于 wait 状态时，调用线程对象的 interrupt 方法会出现 InterruptedException 异常
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Test {

    public static void main(String[] args) {

        try {
            Object lock = new Object();

            ThreadA a = new ThreadA(lock);
            a.start();

            Thread.sleep(5000);

            a.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
