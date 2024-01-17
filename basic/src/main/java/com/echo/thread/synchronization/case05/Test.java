package com.echo.thread.synchronization.case05;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 16:58
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				脏读：
 * 					执行结果：
 * 					getValue method thread name=main username=B password=AA
 * 					setValue method thread name=Thread-0 username=B password=BB
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Test {

    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            ThreadA thread = new ThreadA(publicVarRef);
            thread.start();
            Thread.sleep(1);
            publicVarRef.getValue();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
