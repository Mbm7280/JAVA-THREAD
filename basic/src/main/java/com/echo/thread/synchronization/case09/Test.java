package com.echo.thread.synchronization.case09;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 17:31
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				同步继承：
 * 					同步不能继承，所以子类也需要添加 synchronized 关键字
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Test {

    public static void main(String[] args) {
        Sub subRef = new Sub();

        MyThreadA a = new MyThreadA(subRef);
        a.setName("A");
        a.start();

        MyThreadB b = new MyThreadB(subRef);
        b.setName("B");
        b.start();
    }

}
