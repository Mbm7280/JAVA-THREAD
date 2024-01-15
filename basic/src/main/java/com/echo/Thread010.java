package com.echo;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 21:16
 * 项目名称: {EBlog}
 * 文件名称: Thread010
 * 文件描述: [Description]: 死锁现象
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread010 implements Runnable {


    private static int count = 100;
    private Boolean flag = true;
    private Object object = new Object();

    @Override
    public void run() {
        if (flag) {
            while (count > 0) {
                synchronized (object) {
                    try {

                        Thread.sleep(10);
                    } catch (Exception e) {

                    }
                    ticket();
                }
            }

        } else {
            while (count > 0) {
                ticket();
            }

        }
    }

    private synchronized void ticket() {
        synchronized (object) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",正在开始出售:" + (100 - count + 1));
                count--;
            }
        }
    }


    public static void main(String[] args) {
        Thread010 thread010 = new Thread010();
        new Thread(thread010, "窗口1").start();
        try {
            Thread.sleep(40);
            thread010.flag = false;
        } catch (Exception e) {

        }
        new Thread(thread010, "窗口2").start();
    }

}
