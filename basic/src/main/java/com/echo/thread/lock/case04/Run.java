package com.echo.thread.lock.case04;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/25 10:04
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantLock]
 * 				ReentrantLock
 * 					多个Condition实现通知部分线程
 * 						通过创建 不同的 Condition 类以及对象的通知方法(进行了分组) 来实现
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) throws InterruptedException {

        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(3000);

        service.signalAll_A();

    }

}
