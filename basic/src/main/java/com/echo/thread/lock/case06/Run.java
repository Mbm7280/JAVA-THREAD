package com.echo.thread.lock.case06;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/25 10:16
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantLock]
 * 				ReentrantLock
 * 					getHoldCount()：
 * 						获取当前线程保持锁定的个数，即lock()方法的调用次数
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        service.serviceMethod1();
    }
}
