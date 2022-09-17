package com.ehco.p1;

/**
 * Thread004
 *  线程停止
 *
 */
public class Thread005 extends Thread{

    private volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {

        }
    }

    public static void main(String[] args) {
        Thread005 thread005 = new Thread005();
        thread005.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 不建议使用stopt停止线程，因为他底层使用强制停止线程 如果线程代码没有执行完毕的情况下则强制停止
//        thread005.stop();

        thread005.flag = false;
    }
}
