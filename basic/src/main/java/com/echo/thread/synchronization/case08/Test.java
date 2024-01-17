package com.echo.thread.synchronization.case08;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 17:27
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				异常：
 * 					当一个线程执行的代码出现异常后，所持有的锁会自动释放
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Test {

    public static void main(String[] args) {
        try {
            Service service = new Service();

            ThreadA a = new ThreadA(service);
            a.setName("a");
            a.start();

            Thread.sleep(500);

            ThreadB b = new ThreadB(service);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
