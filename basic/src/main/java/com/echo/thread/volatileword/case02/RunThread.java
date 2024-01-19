package com.echo.thread.volatileword.case02;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/19 14:30
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-volatile]
 * 				增加了实例变量在多个线程之间的可见性
 * 				不支持原子性
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class RunThread extends Thread {

    volatile private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true) {
        }
        System.out.println("线程被停止了！");
    }

}
