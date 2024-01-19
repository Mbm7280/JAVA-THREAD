package com.echo.thread.volatileword.case06;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/19 14:53
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-Atomic]
 * 				运行结果正常，但顺序异常
 * 				addAndGet() 方法是原子操作，但是方法之间调用却不是原子操作
 * 				在方法上加上 synchronized 关键字
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {
        try {
            MyService service = new MyService();

            MyThread[] array = new MyThread[5];
            for (int i = 0; i < array.length; i++) {
                array[i] = new MyThread(service);
            }
            for (int i = 0; i < array.length; i++) {
                array[i].start();
            }
            Thread.sleep(1000);
            System.out.println(service.aiRef.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
