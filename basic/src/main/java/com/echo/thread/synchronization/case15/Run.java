package com.echo.thread.synchronization.case15;


/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/18 14:28
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				synchronized(this) 除了指向当前对象
 * 				同样支持 synchronized (非 this 对象)：
 * 					如果在一个类中有很多 synchronized 方法，这时虽然可以实现同步，但是会出现堵塞情况，效率不高
 * 					如果使用 synchronized (非 this 对象) 则 与 synchronized(this) 是异步执行 可提高效率
 *
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

    public static void main(String[] args) {
        Service service = new Service();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

    }

}
