package com.ehco.p1;
/**
 * 当多个线程同时共享同一个全局变量做写的操作时候，可能会受到其他线程的干扰。
 * 解决办法一：Synchronized
 *              加在代码块上，使用 object 对应的就是加在对象实例上
 *              如果该方法为普通方法的情况下 可以使用普通对象或者属性作为锁。
 */
public class Thread010 implements Runnable {
    private static int count = 100;
    private Object object = new Object();

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    private void ticket(){
        synchronized (object) {
            if(count > 0) {
                try{
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "：正在出售：" + (100 - count + 1));
                count --;
            }
        }
    }

    public static void main(String[] args) {
        Thread008 thread008 = new Thread008();
        Thread thread1 = new Thread(thread008,"窗口一");
        Thread thread2 = new Thread(thread008,"窗口二");
        thread1.start();
        thread2.start();

    }

}
