package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 16:19
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread007
 * 文件描述: [java-thread-methods-interrupt]
 *          终止线程:
 *              interrupt:
 *                  在当前线程中打了一个停止的标记，并不会直接中止该线程。具体做什么事情由写代码的人决定，通常我们会中止该线程。
 *          该方法是用于获取当前线程的唯一标识
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread007 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000; i++) {
            System.out.println("i-" + (i + 1));
        }
    }


    public static void main(String[] args) {
        Thread007 thread = new Thread007();
        thread.start();
        /**
         * 示例：
         *      调用 interrupt() 方法
         *      但是线程并未被终止，而是依旧运行
         *      线程的中断机制是使用中断状态这一内部标志实现的。中断状态在调用线程的interrupt()方法时被设置。
         */
        thread.interrupt();
    }

}
