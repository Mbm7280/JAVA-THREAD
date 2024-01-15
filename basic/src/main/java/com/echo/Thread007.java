package com.echo;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 20:30
 * 项目名称: {EBlog}
 * 文件名称: Thread007
 * 文件描述: [Description]: 卖票问题-解决-synchronized加锁——代码块
 *      synchronized是Java中的关键字，是一种同步锁。它修饰的对象有以下几种:
 *          修饰一个代码块:被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来 的代码，作用的对象是调用这个代码块的对象
 *          修饰一个方法:被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象 是调用这个方法的对象
 *          修饰一个静态的方法:其作用的范围是整个静态方法，作用的对象是这个类的所有对象
 *          修饰一个类:其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread007 implements Runnable {

    // 票数为100张
    private static int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    public void ticket() {
        synchronized (Thread007.class) {
            if (count > 0) {
                try {
                    Thread.sleep(30);
                } catch (Exception e) {

                }
                System.out.println(Thread.currentThread().getName() + ",正在出票第" + (100 - count + 1) + "张");
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Thread007 ticketThread = new Thread007();
        new Thread(ticketThread, "窗口1").start();
        new Thread(ticketThread, "窗口2").start();
    }


}
