package com.echo.thread.lock.case21;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/26 15:10
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantReadWriteLock]
 * 				ReentrantReadWriteLock
 * 					读读共享
 * 					写写互斥
 * 					读写互斥
 * 					写读互斥
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) throws InterruptedException {

        Service service = new Service();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(1000);

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

    }

}