package com.echo.thread.synchronization.case01;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 15:35
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread002
 * 文件描述: [java-thread-synchronization]
 *              两个线程运行：
 *                  运行结果：   交叉执行，由于访问同一个对象的方法，cpu时间分配导致
 *                      a set over!
 *                      b set over!
 *                      b num=200
 *                      a num=100
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread002 extends Thread{

    private Thread001Object numRef;

    public Thread002(Thread001Object numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }

    public static void main(String[] args) {

        Thread001Object numRef = new Thread001Object();

        Thread001 athread = new Thread001(numRef);
        athread.start();

        Thread002 bthread = new Thread002(numRef);
        bthread.start();

    }


}
