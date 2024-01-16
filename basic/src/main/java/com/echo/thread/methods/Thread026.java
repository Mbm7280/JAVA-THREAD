package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 15:55
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread026
 * 文件描述: [java-thread-methods-daemon]
 *          守护线程:
 *              一种特殊线程，进程中不存在非守护线程，则自动销毁
 *
 *              高优先级线程大部分先执行完，但并不代表先全部执行完
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread026 extends Thread {

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Thread026 thread = new Thread026();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("离开thread对象后不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
