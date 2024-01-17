package com.echo.thread.synchronization.case01;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 15:35
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread001
 * 文件描述: [Description]
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread001 extends Thread{

    private Thread001Object numRef;

    public Thread001(Thread001Object numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }

}
