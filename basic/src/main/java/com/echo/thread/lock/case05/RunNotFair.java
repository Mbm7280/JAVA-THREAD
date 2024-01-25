package com.echo.thread.lock.case05;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/25 10:13
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantLock]
 * 				ReentrantLock
 * 					非公平锁：
 * 						获取锁的顺序不是按照加锁顺序
 * 						一种抢占机制，谁先抢到谁执行
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class RunNotFair {

    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("★线程" + Thread.currentThread().getName()
                        + "运行了");
                service.serviceMethod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

    }
}
