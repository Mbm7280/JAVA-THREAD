package com.echo.thread.methods;

import java.lang.Thread;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 16:51
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread008
 * 文件描述: [java-thread-methods-interrupted]
 *          终止线程:
 *              interrupt:
 *                  在当前线程中打了一个停止的标记，并不会直接中止该线程。具体做什么事情由写代码的人决定，通常我们会中止该线程。
 *              检测当前线程的状态:
 *                  interrupted:
 *                      判断当前线程是否处于停止状态 / 取得线程的中断状态
 *                      该方法除了返回当前线程的中断状态外，还会清除当前线程的中断状态。
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread008 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000; i++) {
//            System.out.println("i-" + (i + 1));
        }
    }


    public static void main(String[] args) {
        Thread008 thread = new Thread008();
        thread.start();
        // 线程的中断机制是使用中断状态这一内部标志实现的。中断状态在调用线程的interrupt()方法时被设置。
        thread.interrupt();
        /**
         *  调用 interrupted() 方法
         *      该方法除了返回当前线程的中断状态外，还会清除当前线程的中断状态。换句话说，
         *      如果连续两次调用该方法，则第二次调用将返回 false（在第一次调用已清除了其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外）。
         */
        System.out.println("是否停止1？=" + thread.interrupted());   // false
        System.out.println("是否停止2？=" + thread.interrupted());   // false
        System.out.println("--end--");
    }

}
