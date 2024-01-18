package com.echo.thread.synchronization.case17;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 14:39
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				静态 synchronized 方法
 *					可以作用在 静态方法上，作用则是对当前 Class 类 进行加锁
 *					而作用在 非静态方法上，作用则是对当前 对象 进行加锁
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {

        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();

    }

}
