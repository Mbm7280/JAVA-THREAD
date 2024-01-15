package com.echo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 20:17
 * 项目名称: {EBlog}
 * 文件名称: Thread003
 * 文件描述: [Description]:
 *      有简单类型参数，与call()方法的返回类型相对应。
 *      一个与Runnable 接口非常相似的接口。
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread003 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "echo";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<String>(new Thread003());
        Thread thread = new Thread(futureTask);
        thread.start();
        String result = futureTask.get();
        System.out.println(result);


    }

}
