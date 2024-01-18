package com.echo.thread.synchronization.case16;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 14:35
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				synchronized(非 this ) 是将此 非 this 对象当做对象监视器来看待
 * 				不同的 对象监视器 之间并不冲突，除非多个线程调用同一个 synchronized(对象) 则会导致同一时间只能被一个线程持有
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/

public class Run1_2 {

    public static void main(String[] args) {
        Service service = new Service();
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();

        ThreadA a = new ThreadA(service, object1);
        a.setName("a");
        a.start();

        ThreadB b = new ThreadB(service, object2);
        b.setName("b");
        b.start();
    }

}
