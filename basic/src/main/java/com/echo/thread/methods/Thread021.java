package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 15:32
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread021
 * 文件描述: [java-thread-methods-yield]
 *          线程暂停与恢复:
 *              yield():
 *                  放弃当前线程锁获取的cpu资源，放弃时间并不确定
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread021 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
//            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "毫秒！");
    }

    public static void main(String[] args) {
        Thread021 thread = new Thread021();
        thread.start();
    }

}
