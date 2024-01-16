package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 15:13
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread020
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
 *                  易因为线程暂停而导致数据不同步
 *
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread020 extends Thread {
    public static void main(String[] args) throws InterruptedException {

        final SuspendObject myobject = new SuspendObject();

        Thread020 thread1 = new Thread020() {
            @Override
            public void run() {
                myobject.setValue("a", "aa");
            }

            ;
        };
        thread1.setName("a");
        thread1.start();

        Thread.sleep(500);

        Thread020 thread2 = new Thread020() {
            @Override
            public void run() {
                myobject.printUsernamePassword();
            }

            ;
        };
        thread2.start();

    }

}
