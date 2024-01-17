package com.echo.thread.synchronization.case03;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 16:04
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				两个线程竞争： 加锁后，线程同一时间只能被一个线程持有，故顺序执行
 * 					执行结果：synchronized 修饰的方法一定是同步运行
					 begin methodA threadName=A
					 end
					 begin methodA threadName=B
					 end
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {

	public static void main(String[] args) {
		MyObject object = new MyObject();
		ThreadA a = new ThreadA(object);
		a.setName("A");
		ThreadB b = new ThreadB(object);
		b.setName("B");

		a.start();
		b.start();
	}

}
