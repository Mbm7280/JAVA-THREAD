package com.echo;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 20:23
 * 项目名称: {EBlog}
 * 文件名称: Thread005
 * 文件描述: [Description]:
 *      优雅的停止一个线程
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread005 extends Thread {

    private volatile boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            System.out.println("I am running");
        }

    }

    public void stopThrad() {
        this.flag = false;
    }

    public static void main(String[] args) {
        Thread005 thread005 = new Thread005();
        thread005.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        thread005.stopThrad();
        System.out.println("Thread Has Stopped");
    }

}
