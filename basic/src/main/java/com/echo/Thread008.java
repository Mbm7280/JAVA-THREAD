package com.echo;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 21:01
 * 项目名称: {EBlog}
 * 文件名称: Thread008
 * 文件描述: [Description]: 卖票问题-解决-synchronized加锁——对象锁
 *      如果该方法为普通方法的情况下 可以使用普通对象或者属性作为锁。
 *      如果该方法为静态方法的情况，则必须使用当前类的Class或者是静态属性作为锁。
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread008 implements Runnable {
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
        Thread008 thread008 = new Thread008();
        new Thread(thread008, "窗口1").start();
        new Thread(thread008, "窗口2").start();
        thread008.flag = false;

    }
}
