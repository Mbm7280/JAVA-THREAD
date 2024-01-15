package com.echo.thread.creation;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/5 14:37
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread001
 * 文件描述: [java-thread-creation-mode-extendThread]
 *          扩展Thread类
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread001 extends Thread {

    /**
     * 在run方法中写线程需要执行的代码
     */
    @Override
    public void run() {
        /**
         * Java中的所有线程都有一个优先级，这个整数值介于Thread.MIN_PRIORITY（1）和
         * Thread.MAX_PRIORITY（10）之间，默认优先级是Thread.NORM_PRIORITY（5）。线程的
         * 执行顺序并没有保证，通常，较高优先级的线程将在较低优先级的钱程之前执行。
         */
        System.out.println(Thread.currentThread().getName() + ",我是子线程");
    }

    public static void main(String[] args) {
        /**
         * 所有的Java 程序，不论并发与否，都有一个名为主线程的Thread 对象。执行该程序时， Java
         * 虚拟机（ JVM ）将创建一个新Thread 并在该线程中执行main()方法。这是非并发应用程序中
         * 唯一的线程，也是并发应用程序中的第一个线程。
         */
        System.out.println(Thread.currentThread().getName() + "，我是主线程");
        new Thread001().start();
    }

}
