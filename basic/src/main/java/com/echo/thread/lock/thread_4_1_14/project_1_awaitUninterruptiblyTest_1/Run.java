package com.echo.thread.lock.thread_4_1_14.project_1_awaitUninterruptiblyTest_1;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/26 14:18
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-ReentrantLock]
 * 				ReentrantLock
 * 					tryLock(long)：
 * 						如果在该指定时间内，获取该资源时 未被另一个线程保持 才获取该锁定
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

	public static void main(String[] args) {
		try {
			Service service = new Service();
			MyThread myThread = new MyThread(service);
			myThread.start();
			Thread.sleep(3000);
			myThread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
