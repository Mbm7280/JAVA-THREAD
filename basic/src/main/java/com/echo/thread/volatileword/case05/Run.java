package com.echo.thread.volatileword.case05;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/19 14:42
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-Atomic]
 * 				原子类也可以保证同步性,可以在没有锁的情况下做到线程安全
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {
        AddCountThread countService = new AddCountThread();

        Thread t1 = new Thread(countService);
        t1.start();

        Thread t2 = new Thread(countService);
        t2.start();

        Thread t3 = new Thread(countService);
        t3.start();

        Thread t4 = new Thread(countService);
        t4.start();

        Thread t5 = new Thread(countService);
        t5.start();

    }

}
