package com.echo.thread.synchronization.case22;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 15:46
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				锁 对象时  只要该对象不变，即使该对象的属性变更，依旧不影响同步
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {

        try {
            Service service = new Service();
            Userinfo userinfo = new Userinfo();

            ThreadA a = new ThreadA(service, userinfo);
            a.setName("a");
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(service, userinfo);
            b.setName("b");
            b.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
