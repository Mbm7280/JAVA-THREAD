package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 11:16
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread015
 * 文件描述: [java-thread-methods-stop]
 *          终止线程:
 *              stop():
 *                  方法过于暴力，且该方法已过时。
 *                  使用此方法，强制性终止线程，可能会
 *                      导致一些逻辑未执行完成
 *                      对锁定的对象进行了解锁，导致数据得不到同步处理，出现数据不一致
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread015 extends Thread {

    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            Thread015 thread = new Thread015();
            thread.start();
            Thread.sleep(8000);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
