package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 17:06
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread010
 * 文件描述: [java-thread-methods-interrupted]
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
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread009 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("i-" + (i + 1));
        }
    }


    public static void main(String[] args) {
        Thread009 thread = new Thread009();
        thread.start();
        // 线程的中断机制是使用中断状态这一内部标志实现的。中断状态在调用线程的interrupt()方法时被设置。
        thread.interrupt();
        /**
         *  调用 isInterrupted() 方法
         *      该方法除了返回当前线程的中断状态外，不会清除当前线程的中断状态。
         */
        System.out.println("是否停止1？=" + thread.isInterrupted());   // true
        System.out.println("是否停止2？=" + thread.isInterrupted());   // true
        System.out.println("--end--");
    }

}
