package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 16:09
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread006
 * 文件描述: [java-thread-methods-getId]
 *          getId()
 *          该方法是用于获取当前线程的唯一标识
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread006 extends Thread {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + " " + currentThread.getId() );
    }

}
