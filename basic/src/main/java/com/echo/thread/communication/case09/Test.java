package com.echo.thread.communication.case09;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/22 11:13
 * 项目名称: {JAVA-THREAD}
 * 文件名称: MyRun
 * 文件描述: [java-thread-join]
 * 				join
 * 					等待线程对象销毁
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/

public class Test {

    public static void main(String[] args) {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();
            threadTest.join();
            System.out.println("我想当threadTest对象执行完毕后我再执行，我做到了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
