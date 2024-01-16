package com.echo.thread.methods;

public class SynchronizedObject19 {
    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远 suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
