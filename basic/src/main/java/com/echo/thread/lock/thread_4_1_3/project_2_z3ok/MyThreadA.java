package com.echo.thread.lock.thread_4_1_3.project_2_z3ok;

public class MyThreadA extends Thread {

	private MyService myService;

	public MyThreadA(MyService myService) {
		super();
		this.myService = myService;	
	}

	@Override
	public void run() {
		myService.waitMethod();
	}

}