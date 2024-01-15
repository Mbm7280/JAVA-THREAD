package com.echo;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 20:29
 * 项目名称: {EBlog}
 * 文件名称: Thread006
 * 文件描述: [Description]: 卖票问题
 *      卖同一张票
 *      跳票
 *      多卖
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread006 implements Runnable {

    // 票数为100张
    private static int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    public void ticket() {
        if (count > 0) {
            try {
                Thread.sleep(30);
            } catch (Exception e) {

            }
            System.out.println(Thread.currentThread().getName() + ",正在出票第" + (100 - count + 1) + "张");
            count--;
        }
    }

    public static void main(String[] args) {
        Thread006 ticketThread = new Thread006();
        new Thread(ticketThread, "窗口1").start();
        new Thread(ticketThread, "窗口2").start();
    }

}
