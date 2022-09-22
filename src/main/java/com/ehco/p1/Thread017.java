package com.ehco.p1;

/**
 * interrupt（）方法：
 *      作用是中断此线程（此线程不一定是当前线程，而是指调用该方法的Thread实例所代表的线程），但实际上只是给线程设置一个中断标志，线程仍会继续运行。
 *
 * interrupted（）方法：
 *      作用是测试当前线程是否被中断（检查中断标志），返回一个boolean并清除中断状态，第二次再调用时中断状态已经被清除，将返回一个false。
 *
 * isInterrupted（）方法：
 *      作用是只测试此线程是否被中断 ，不清除中断状态。
 *
 */
public class Thread017 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i="+(i+1));
        }
    }

    public static void main(String[] args) {
//        Thread017 thread = new Thread017();
//        thread.start();
//        thread.interrupt(); // 线程仍在继续运行，并未停止，但已经给线程设置了中断标志
//        System.out.println("第一次调用thread.isInterrupted()："+thread.isInterrupted()); // 都会输出true，也说明isInterrupted（）方法并不会清除中断状态
//        System.out.println("第二次调用thread.isInterrupted()："+thread.isInterrupted()); // 都会输出true，也说明isInterrupted（）方法并不会清除中断状态
//
//        System.out.println("第一次调用thread.interrupted()："+thread.interrupted()); // false interrupted（）方法测试的是当前线程是否被中断
//        System.out.println("第二次调用thread.interrupted()："+thread.interrupted()); // false 这里当前线程是main线程
//
//        System.out.println("thread是否存活："+thread.isAlive());

        Thread.currentThread().interrupt();
        System.out.println("第一次调用Thread.currentThread().interrupt()："
                +Thread.currentThread().isInterrupted());       // true
        System.out.println("第一次调用thread.interrupted()："
                +Thread.currentThread().interrupted());         // true
        System.out.println("第二次调用thread.interrupted()："
                +Thread.currentThread().interrupted());         // false
    }
}
