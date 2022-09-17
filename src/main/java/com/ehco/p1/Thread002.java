package com.ehco.p1;


/**
 * Thread002
 *  多线程四种创建-实现Runnable接口
 *
 */
public class Thread002 implements Runnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-我是主线程!!!!");
        new Thread(new Thread002()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-我是子线程!!!!");
    }
}
