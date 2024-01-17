package com.echo.thread.synchronization.case02;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 15:51
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				两个线程竞争： 加锁后，线程同一时间只能被一个线程持有，故顺序执行
 * 					a set over!
 * 					a num=100
 * 					b set over!
 *					b num=200
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {
	public static void main(String[] args) {

		HasSelfPrivateNum numRef = new HasSelfPrivateNum();

		ThreadA athread = new ThreadA(numRef);
		athread.start();

		ThreadB bthread = new ThreadB(numRef);
		bthread.start();

	}
}
