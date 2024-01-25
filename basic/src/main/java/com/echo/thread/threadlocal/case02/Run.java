package com.echo.thread.threadlocal.case02;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/25 09:31
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-InheritableThreadLocal]
 * 				InheritableThreadLocal
 * 					可以在子线程中获取父线程继承下来的值
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("       在Main线程中取值=" + Tools.tl.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
