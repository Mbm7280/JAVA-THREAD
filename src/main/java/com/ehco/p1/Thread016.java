package com.ehco.p1;

/**
 * wait:
 *  参数：
 *      是Object方法、有参数时：wait（500）表示Time_waiting状态  无参数：wait（）或wait（0）都表示无限等待:waiting状态
 *  作用：
 *      1.使当前的线程进行等待
 *      2.释放当前的锁；
 *      3.被唤醒时，重新尝试获取这个锁
 *  用法：
 *      1.必须配合synchronized使用
 *      2.且使用的必须为同一个对象：synchronized (A)配合A.wait()使用
 *      3.当线程执行到object.wait()时，此线程会同时释放锁synchronized (object)；当它结束了wait后，此线程又会重新去争抢锁synchronized (object)。
 *
 *  结束等待的条件：
 *      1.其他线程（也可以不是线程）调用了该对象的notify或notifyAll方法
 *      2.其他线程（也可以不是线程）调用该等待线程的interrupted方法
 *      3.等待时间超时：wait（有参）wait(0)表示的是无限等待
 *  notify()：方法——随机唤醒一个wait的线程
 *  notifyAll()：方法——唤醒所有wait的线程,让这些被唤醒的线程去争抢，按争抢顺序依次执行
 */
public class Thread016 {

    public static void main(String[] args) {

        Object object = new Object();

        Thread t1 = new Thread( () -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程一执行完成");
            }
        });

        Thread t2 = new Thread( () -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程二执行完成");
            }
        });

        Thread t3 = new Thread( () -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程三执行完成");
            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread thread4=new Thread(()->{
            synchronized (object){
//                object.notify();      // 使用一次notify只能唤醒一个线程；
                object.notifyAll();     // 使用一次notifyAll可唤醒所有的线程
                System.out.println("线程4去唤醒wait的线程");
            }

        });
        thread4.start();








    }

}
