package com.echo.thread.synchronization.case17;

public class ThreadB extends Thread {
	@Override
	public void run() {
		Service.printB();
	}
}
