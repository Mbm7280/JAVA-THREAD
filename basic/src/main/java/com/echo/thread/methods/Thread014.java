package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 11:09
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread014
 * 文件描述: [java-thread-methods-stop]
 *          终止线程:
 *              stop():
 *                  方法过于暴力，且该方法已过时。
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread014 extends Thread {

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
            Thread014 thread = new Thread014();
            thread.start();
            Thread.sleep(8000);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
