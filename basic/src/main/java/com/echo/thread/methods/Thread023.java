package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 15:43
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread023
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
public class Thread023 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread2 run priority=" + this.getPriority());
    }

}
