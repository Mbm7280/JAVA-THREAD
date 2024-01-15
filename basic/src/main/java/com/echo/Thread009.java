package com.echo;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 21:07
 * 项目名称: {EBlog}
 * 文件名称: Thread009
 * 文件描述: [Description]: 锁的可重入性
 *      synchronized
 *      当一个线程获取到锁之后，在此请求获取该锁的时候，直接可以获取该对象锁。
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread009 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",我是子线程");
        a();
    }

    public synchronized void a() {
        // this 锁
        System.out.println(Thread.currentThread().getName() + ",我是方法A 开始");
        b();
        System.out.println(Thread.currentThread().getName() + ",我是方法A 结束");
    }

    public synchronized void b() {
        System.out.println(Thread.currentThread().getName() + ",我是方法B");
    }

    public static void main(String[] args) {
        new Thread(new Thread009()).start();
    }

}
