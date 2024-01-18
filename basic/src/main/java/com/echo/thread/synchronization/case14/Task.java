package com.echo.thread.synchronization.case14;

public class Task {

	synchronized public void otherMethod() {
		System.out.println(Thread.currentThread().getName() + "------------------------run--otherMethod");
	}

	public void doLongTimeTask() {
		synchronized (this) {
			for (int i = 0; i < 3000; i++) {
				System.out.println("synchronized threadName="
						+ Thread.currentThread().getName() + " i=" + (i + 1));
			}
		}

	}
}
