package com.echo.thread.lock.case02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/25 09:56
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantLock]
 * 				ReentrantLock
 * 					Condition
 * 						await [调用此方法前，必须先调用 lock() 方法获得同步监视器]
 * 							synchronized 使用 wait & notify 方法来实现线程的等待与通知
 * 							ReentrantLock 则使用 condition 中的方法来实现
 *
 * 							synchronized 的 wait & notify 对线程的选择是 由 jvm 随机选择
 * 							ReentrantLock 的 condition 却是可以自主选择
 *
 *
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            condition.await();
            System.out.println(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}