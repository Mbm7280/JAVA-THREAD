package com.echo.thread.synchronization.case21;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 15:43
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				此时 线程A 获取锁是 lock = "123";
 * 				此时 线程B 获取锁是 lock = "456";	异步执行
 *
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run1 {

    public static void main(String[] args) throws InterruptedException {

        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");

        ThreadB b = new ThreadB(service);
        b.setName("B");

        a.start();
        Thread.sleep(50);
        b.start();
    }
}
