package com.echo.thread.synchronization.case20;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 15:30
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				同步方法极易造成 死循环
 * 				故使用 同步代码块来 解决此问题
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {
        Service service = new Service();

        ThreadA athread = new ThreadA(service);
        athread.start();

        ThreadB bthread = new ThreadB(service);
        bthread.start();
    }

}
