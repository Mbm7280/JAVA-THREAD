package com.echo.thread.creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 10:06
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread003
 * 文件描述: [java-thread-creation-mode-implements-Callable]
 *          实现Callable接口
 *              使用的为call()方法
 *              有返回值
 *              可以抛出异常
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread003 implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return "call() invoked!";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread003 callableThread = new Thread003();

        // 设置Callable对象，泛型表示Callable的返回类型
        FutureTask<String> futureTask = new FutureTask<String>(callableThread);
        // 启动处理线程
        new Thread(futureTask).start();
        // 同步等待线程运行的结果
        String result = futureTask.get();
        // 5s后得到结果
        System.out.println(result);

    }

}
