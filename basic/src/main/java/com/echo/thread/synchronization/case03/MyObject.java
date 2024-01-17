package com.echo.thread.synchronization.case03;

public class MyObject {

    /**
     * synchronized 修饰的方法一定是同步运行
     */
//	public void methodA() {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName="
                    + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
