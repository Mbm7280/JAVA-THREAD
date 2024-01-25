package com.echo.thread.lock.project_1_awaitUntilTest;

public class MyThreadB extends Thread {

	private Service service;

	public MyThreadB(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.notifyMethod();
	}

}