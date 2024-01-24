package com.echo.thread.communication.case10;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/24 16:54
 * 项目名称: {JAVA-THREAD}
 * 文件名称: MyRun
 * 文件描述: [java-thread-join]
 * 				join
 * 					等待线程对象销毁
 *					如果当前线程被中断，则会异常
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {

        try {
            ThreadB b = new ThreadB();
            b.start();

            Thread.sleep(500);

            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
