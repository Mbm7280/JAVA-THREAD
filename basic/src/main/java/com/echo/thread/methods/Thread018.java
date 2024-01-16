package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 14:38
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread018
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
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread018 extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }


    public static void main(String[] args) {

        try {
            Thread018 thread = new Thread018();
            thread.start();
            Thread.sleep(5000);
            // A
            thread.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i="
                    + thread.getI());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i="
                    + thread.getI());
            thread.resume();
            Thread.sleep(5000);

            // B
            thread.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i="
                    + thread.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i="
                    + thread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
