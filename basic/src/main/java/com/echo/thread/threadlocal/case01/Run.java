package com.echo.thread.threadlocal.case01;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/25 09:25
 * 项目名称: {JAVA-THREAD}
 * 文件名称: MyRun
 * 文件描述: [java-thread-threadlocal]
 * 				threadlocal
 * 					变量值的共享可以使用 public static 的形式来确保该变量被所有线程共享
 * 					但是每个线程都有自己的一个共享变量，则需要通过 threadlocal 来实现
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {

        try {
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();

            for (int i = 0; i < 100; i++) {
                Tools.tl.set("Main" + (i + 1));
                System.out.println("Main get Value=" + Tools.tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
