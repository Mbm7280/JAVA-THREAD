package com.ehco.p1;

/**
 * 当多个线程同时共享同一个全局变量做写的操作时候，可能会受到其他线程的干扰。
 * 解决办法二：ReentrantLock
 */
public class Thread007 implements Runnable{

    private static int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    private static synchronized void ticket(){
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

    public static void main(String[] args) {
        Thread007 thread007 = new Thread007();
        Thread thread1 = new Thread(thread007,"窗口一");
        Thread thread2 = new Thread(thread007,"窗口二");
        thread1.start();
        thread2.start();

    }

}
