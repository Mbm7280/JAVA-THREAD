package com.echo;

import java.util.ArrayList;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/17 11:32
 * 项目名称: {EBlog}
 * 文件名称: Thread015
 * 文件描述: [Description]: Volatile无法保证原子性
 *      Volatile为了能够保证数据的可见性，但是不能够保证原子性，及时的将工作内存的数据刷新主内存中，
 *      导致其他的工作内存的数据变为无效状态，其他工作内存做的count++操作等于就是无效丢失了，
 *      这是为什么我们加上Volatile count结果在小于10000以内。
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread015 extends Thread {

    private static volatile int count;

    public static void create() {
        count++;
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread tempThread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    create();
                }
            });
            threads.add(tempThread);
            tempThread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(count);
    }

}
