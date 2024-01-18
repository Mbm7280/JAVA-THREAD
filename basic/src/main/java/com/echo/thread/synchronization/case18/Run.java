package com.echo.thread.synchronization.case18;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 15:17
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				静态 synchronized 方法
 *					可以作用在 静态方法上，作用则是对当前 Class 类 进行加锁
 *					而作用在 非静态方法上，作用则是对当前 对象 进行加锁
 *
 *				运行结果：
 *					A B 同步  C 异步
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {

        Service service = new Service();

        // 类锁
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        // 类锁
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        // 对象锁
        ThreadC c = new ThreadC(service);
        c.setName("C");
        c.start();

    }

}
