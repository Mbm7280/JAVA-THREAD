package com.echo.thread.synchronization.case19;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 15:23
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				Jvm String 具有常量池缓存的功能
 * 					所以在不推荐使用 String 作为 synchronized 对象使用
 * 				运行结果：
 * 					A
 * 					A
 * 					A
 * 					A
 * 					A
 * 					......
 * 					因为 stringParam 的两个值 都为 A
 * 					故 线程B 无法执行
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {

        Service service = new Service();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

    }

}
