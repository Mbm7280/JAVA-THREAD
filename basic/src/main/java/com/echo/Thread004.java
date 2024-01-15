package com.echo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/****************************************************
 * 创建人：@author ECHO
 * 创建时间: 2023/9/16 20:20
 * 项目名称: {EBlog}
 * 文件名称: Thread004
 * 文件描述: [Description]: TODO
 * version：1.0
 * All rights Reserved, Designed By ECHO
 *
 ********************************************************/
public class Thread004 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "我是线程池"));
    }

}
