package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 12:07
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread002
 * 文件描述: [java-thread-methods-currentThread]
 *          currentThread()
 *          该方法是Thread类中的类方法，可以用类名调用，该方法返回当前正在使用CPU资源的线程。
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread002 extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "我是子线程");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "main");
        new Thread002().start();
    }

}
