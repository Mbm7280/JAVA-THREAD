package com.echo.thread.communication.case11;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/24 16:56
 * 项目名称: {JAVA-THREAD}
 * 文件名称: MyRun
 * 文件描述: [java-thread-join]
 * 				join
 * 					等待线程对象销毁
 *					如果当前线程被中断，则会异常
 *					join(long) 底层使用wait(long)方法实现，所以join(long)会释放锁
 *					sleep(long) 不会释放锁
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Test {

    public static void main(String[] args) {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();

            /**
             * 都是只等待两秒
             */
            threadTest.join(2000);//只等2秒
//			Thread.sleep(2000);

            System.out.println("  end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
