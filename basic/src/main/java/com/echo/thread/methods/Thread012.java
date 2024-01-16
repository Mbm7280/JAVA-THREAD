package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 10:54
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread012
 * 文件描述: [java-thread-methods-interrupt]
 *          终止线程:
 *              interrupt:
 *                  在当前线程中打了一个停止的标记，并不会直接中止该线程。具体做什么事情由写代码的人决定，通常我们会中止该线程。
 *              检测当前线程的状态:
 *                  interrupted:
 *                      判断当前线程是否处于停止状态 / 取得线程的中断状态
 *                      该方法除了返回当前线程的中断状态外，还会清除当前线程的中断状态。
 *                  isInterrupted:
 *                      判断当前线程是否处于停止状态 / 取得线程的中断状态
 *                      该方法除了返回当前线程的中断状态外，不会清除当前线程的中断状态。
 *              sleep()情况下终止线程:
 *                      如果线程处于 sleep 状态下停止线程，则会进入到catch中并清除停止状态值，使之变成false
 *
 ，
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread012 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止-进入catch-" + this.isInterrupted());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        try {
            Thread012 thread = new Thread012();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }

}
