package com.echo.thread.lock.case16;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/26 14:18
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantLock]
 * 				ReentrantLock
 * 					tryLock(long)：
 * 						如果在该指定时间内，获取该资源时 未被另一个线程保持 才获取该锁定
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/

public class Run {

    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();

        Runnable runnableRef = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        + "调用waitMethod时间：" + System.currentTimeMillis());
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnableRef);
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(runnableRef);
        threadB.setName("B");
        threadB.start();
    }
}