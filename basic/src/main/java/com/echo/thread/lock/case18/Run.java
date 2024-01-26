package com.echo.thread.lock.case18;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/26 15:05
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantReadWriteLock]
 * 				ReentrantReadWriteLock
 * 					读读共享
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        ThreadB b = new ThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}