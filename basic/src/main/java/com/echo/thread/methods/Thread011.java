package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 10:48
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread011
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
public class Thread011 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("已经是停止状态了!我要退出了!");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("循环退出了，但是线程依旧继续运行");
            /**
             * 通过添加异常catch捕捉，可以处理此问题
             */
        } catch (InterruptedException e) {
            System.out.println("进run方法中的catch了！");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread011 thread = new Thread011();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println("end!");
    }

}
