package com.echo.thread.synchronization.case13;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 14:10
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				synchronized：
 * 					当一个线程访问 一个 object 的 synchronized 代码块时，其他线程对于同一个 object 中其他所有 synchronized
 * 					同步代码块的访问将被堵塞， 证实 synchronized 使用的 对象监视器 为同一个
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {
        ObjectService service = new ObjectService();

        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }

}
