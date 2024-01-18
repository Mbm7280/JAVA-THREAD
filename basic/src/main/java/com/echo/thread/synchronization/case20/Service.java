package com.echo.thread.synchronization.case20;

public class Service {

    synchronized public void methodA() {
        System.out.println("methodA begin");
        boolean isContinueRun = true;
        while (isContinueRun) {
        }
        System.out.println("methodA end");
    }

//	public void methodA() {
//		Object object1 = new Object();
//		synchronized (object1) {
//			System.out.println("methodA begin");
//			boolean isContinueRun = true;
//			while (isContinueRun) {
//			}
//			System.out.println("methodA end");
//		}
//	}

    synchronized public void methodB() {
        System.out.println("methodB begin");
        System.out.println("methodB end");
    }

//	public void methodB() {
//		Object object2 = new Object();
//		synchronized (object2) {
//			System.out.println("methodB begin");
//			System.out.println("methodB end");
//		}
//	}
}
