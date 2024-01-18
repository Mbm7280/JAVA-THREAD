package com.echo.thread.synchronization.case17;

public class ThreadA extends Thread {
	@Override
	public void run() {
		Service.printA();
	}

}
