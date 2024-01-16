package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/16 11:19
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread016
 * 文件描述: [java-thread-methods-stop]
 *          终止线程:
 *              stop():
 *                  方法过于暴力，且该方法已过时。
 *                  使用此方法，强制性终止线程，可能会
 *                      导致一些逻辑未执行完成
 *                      对锁定的对象进行了解锁，导致数据得不到同步处理，出现数据不一致
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread016 extends Thread {

    private SynchronizedObject object;

    public Thread016(SynchronizedObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }


    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            Thread016 thread = new Thread016(object);
            thread.start();
            Thread.sleep(500);
            // 强制 stop 导致数据不一致
            thread.stop();
            System.out.println(object.getUsername() + " "
                    + object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
