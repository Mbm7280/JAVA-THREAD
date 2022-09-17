package com.ehco.p1;

/**
 *  synchronized 的可重入性
 */
public class Thread011 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",我是子线程");
        a();
    }

    public synchronized void a () {
        System.out.println(Thread.currentThread().getName() + "：我是方法A 开始");
        b();
        System.out.println(Thread.currentThread().getName() + "：我是方法A 结束");
    }

    public synchronized void b() {
        System.out.println(Thread.currentThread().getName() + "：我是方法B");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ",我是主线程");
        Thread011 thread011 = new Thread011();
        Thread thread1 = new Thread(thread011,"窗口一");
        Thread thread2 = new Thread(thread011,"窗口二");
        thread1.start();
        thread2.start();
    }
}
