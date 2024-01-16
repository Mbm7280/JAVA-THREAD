package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 14:20
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread017
 * 文件描述: [java-thread-methods-stop]
 *          终止线程:
 *              stop():
 *                  方法过于暴力，且该方法已过时。
 *                  使用此方法，强制性终止线程，可能会
 *                      导致一些逻辑未执行完成
 *                      对锁定的对象进行了解锁，导致数据得不到同步处理，出现数据不一致
 *              return:
 *                  在if判断中使用return 跳出循环
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread017 extends Thread {

    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("停止了!");
                return;
            }
            for (int i = 0; i < 10000; i++) {
                System.out.println("i - " + i);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread017 thread017 = new Thread017();
        thread017.start();
        Thread.sleep(2000);
        thread017.interrupt();
    }

}
