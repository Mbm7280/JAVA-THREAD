package com.echo.thread.lock.project_1_MustUseMoreCondition_Error;

public class ThreadB extends Thread {

	private MyService service;

	public ThreadB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitB();
	}
}

