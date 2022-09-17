package com.ehco.p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Thread004
 *  多线程四种创建-线程池
 *
 */
public class Thread004 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-我是主线程!!!!");
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "线程池"));
    }
}
