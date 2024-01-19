package com.echo.thread.volatileword.case03;


/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/19 14:35
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-volatile]
 * 				增加了实例变量在多个线程之间的可见性
 * 				不具备同步性，即不支持原子性
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/

public class Run {
    public static void main(String[] args) {
        MyThread[] mythreadArray = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }

    }

}
