package com.echo.thread.synchronization.case07;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/17 17:22
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Run
 * 文件描述: [java-thread-synchronization]
 * 				可重入性：
 * 					可以再次获取自己的内部锁
 * 					也可以在父子类继承中
 *
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Run {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}
}
