package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 14:58
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread019
 * 文件描述: [java-thread-methods-suspend&resume]
 *          线程暂停与恢复:
 *              suspend():
 *                  暂停当前线程
 *                  使用此方法，强制性终止线程，可能会
 *                      导致一些逻辑未执行完成
 *                      对锁定的对象进行了解锁，导致数据得不到同步处理，出现数据不一致
 *              resume():
 *                  恢复暂停的当前线程
 *
 *              缺点：
 *                  极易造成公共同步对象被某一线程独占，其他线程无法访问,形成死锁
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread019 extends Thread {
    public static void main(String[] args) {
        try {
            final SynchronizedObject19 object = new SynchronizedObject19();

            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };

            thread1.setName("a");
            thread1.start();

            Thread.sleep(1000);

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out
                            .println("thread2启动，但进入不了printString()方法！");
                    System.out
                            .println("因为printString()方法被a线程锁定并且永远的暂停了！");
                    object.printString();
                }
            };
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
