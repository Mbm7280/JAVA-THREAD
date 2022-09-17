package com.ehco.p1;

/**
 * Thread001
 *  多线程四种创建-继承Thread类,重写 run 方法
 *
 */
public class Thread001 extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-我是子线程!!!!");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-我是主线程!!!!");
        new Thread001().start();
    }
}
