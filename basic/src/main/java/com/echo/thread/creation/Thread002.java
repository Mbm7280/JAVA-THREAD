package com.echo.thread.creation;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/5 14:44
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread002
 * 文件描述: [java-thread-creation-mode-implementsRunnable]
 *          实现Runnable接口
 *              Runnable接口只定义了一种方法：run()方法。这是每个线程的主方法。当执行start()方法启动新线
 *              程时，它将调用run()方法。
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread002 implements Runnable {

    /**
     * 在给定时间内， 线程只能处于一个状态。这些状态是JVM使用的状态，不能映射到操作系统的线程状态。
     * 线程的状态：
     *      NEW：Thread对象已经创建，但是还没有开始执行。
     *      RUNNABLE：Thread对象正在Java虚拟机中运行。
     *      BLOCKED : Thread对象正在等待锁定。
     *      WAITING：Thread 对象正在等待另一个线程的动作。
     *      TIME_WAITING：Thread对象正在等待另一个线程的操作，但是有时间限制。
     *      TERMINATED：Thread对象已经完成了执行。
     */

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",我是子线程");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread002()).start();

        // 匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + ",我是子线程");
//            }
//        }).start();

        // Lambda 方式
//        new Thread(() -> System.out.println(Thread.currentThread().getName() + ",我是子线程")).start();

    }

}
