package com.echo;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/17 11:18
 * 项目名称: {EBlog}
 * 文件名称: Thread014
 * 文件描述: [Description]: 什么是 Volatile
 *      能够保证线程可见性，当一个线程修改共享变量时，能够保证对另外一个线程可见性，
 *      但是注意他不能够保证共享变量的原子性问题。
 *
 *      可见性：能够保证线程可见性，当一个线程修改共享变量时，能够保证对另外一个线程可见性，但是注意他不能够保证共享变量的原子性问题。
 *      顺序性：程序执行程序按照代码的先后顺序执行。
 *      原子性：即一个操作或者多个操作 要么全部执行并且执行的过程，要么失败。
 *
 *      Volatile的底层实现原理
 *          通过汇编lock前缀指令触发底层锁的机制
 *          锁的机制两种：总线锁/MESI缓存一致性协议
 *
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread014 extends Thread{

    /**
     * lock 锁 汇编的指令 强制修改值，立马刷新主内存中 另外线程立马可见刷新主内存数据
     */
    private static volatile boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG) {
            System.out.println("I am running");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread014().start();
        Thread.sleep(1000);
        FLAG = false;
        System.out.println("Thread Stopped");
    }
}
