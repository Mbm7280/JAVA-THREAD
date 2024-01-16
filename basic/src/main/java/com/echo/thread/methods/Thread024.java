package com.echo.thread.methods;

import java.util.Random;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 15:43
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread024
 * 文件描述: [java-thread-methods-priority]
 *          线程优先级:
 *              可以有效的帮助线程执行
 *              分为 10 个等级，优先级越高，得到的cpu资源越多
 *              且预设了三个常量：
 *                  public final static int MIN_PRIORITY = 1;
 *                  public final static int NORM_PRIORITY = 5;
 *                  public final static int MAX_PRIORITY = 10;
 *          具有继承特性：
 *              A线程 启动 B线程，则 B线程 与 A线程 的优先级一致
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread024 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("★★★★★thread 1 use time=" + (endTime - beginTime));
    }

}
