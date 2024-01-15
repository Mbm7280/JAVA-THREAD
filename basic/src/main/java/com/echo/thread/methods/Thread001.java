package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 11:13
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread001
 * 文件描述: [java-thread-methods-start]
 *          start()
 *          线程调用该方法将启动线程，使之从新建状态进入就绪队列排队，
 *          一旦轮到它来享用CPU资源时，就可以脱离创建它的线程独立开始自己的生命周期了。
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread001 extends Thread {

    @Override
    public void run() {
        System.out.println("我是子线程");
    }

    public static void main(String[] args) {
        new Thread001().start();
    }

}
