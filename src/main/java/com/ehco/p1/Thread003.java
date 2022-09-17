package com.ehco.p1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Thread003
 *  多线程四种创建-实现Callable接口
 *      FutureTask 可以接收线程返回值
 *
 */
public class Thread003 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "-我是子线程!!!!");
        return "子线程运行结束";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "-我是主线程!!!!");
        Thread003 thread003 = new Thread003();
        FutureTask<String> futureTask = new FutureTask<>(thread003);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}
