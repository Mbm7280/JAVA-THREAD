package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 12:11
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread004
 * 文件描述: [java-thread-methods-isAlive]
 *          isAlive()
 *          该方法是用于判断当前线程是否处于活动状态
 *          线程处于“新建”状态时，线程调用isAlive()方法返回false。在线程的run()方法结束之前，
 *              即没有进入死亡状态之前，线程调用isAlive()方法返回true.
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread004 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-running-" + this.isAlive());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread004 thread004 = new Thread004();
        System.out.println("begin ==" + thread004.isAlive());
        thread004.start();
        /**
         * 如无此行代码：
         *      end 状态为 true, 但此状态并不确定，因为当前线程 thread004 并未执行完毕
         * 如添加此行代码：
         *      end 转台则为 false, 因为当前线程 thread004 已经执行完毕
         */
        // Thread.sleep(1000);
        System.out.println("end ==" + thread004.isAlive());
    }

}
