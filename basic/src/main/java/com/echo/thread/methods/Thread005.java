package com.echo.thread.methods;

/****************************************************
 * 创建人：Echo
 * 创建时间: 2024/1/15 12:25
 * 项目名称: {JAVA-THREAD}
 * 文件名称: Thread005
 * 文件描述: [java-thread-methods-sleep]
 *          sleep()
 *          该方法是用于使当前线程（即调用该方法的线程）暂停执行一段时间，让其他线程有机会继续执行
 *          但它并不释放对象锁。也就是说如果有synchronized同步快，其他线程仍然不能访问共享数据。注意该方法要捕捉异常。
 *              例如有两个线程同时执行(没有synchronized)一个线程优先级为MAX_PRIORITY，另一个为MIN_PRIORITY，
 *              如果没有Sleep()方法，只有高优先级的线程执行完毕后，低优先级的线程才能够执行；但是高优先级的线程sleep(500)后，低优先级就有机会执行了。
 *          总之，sleep()可以使低优先级的线程得到执行的机会，当然也可以让同优先级、高优先级的线程有执行的机会。
 * version：1.0
 * All rights Reserved, Designed By Echo
 *
 ********************************************************/
public class Thread005 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("threadName-" + Thread.currentThread().getName() + "- begin");
            Thread.sleep(2000);
            System.out.println("threadName-" + Thread.currentThread().getName() + "- end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread005 thread005 = new Thread005();
        System.out.println("begin -" + Thread.currentThread().getName() + "-" + System.currentTimeMillis());
        // 同步执行
        thread005.run();
        // 异步执行
//        thread005.start();
        System.out.println("end   -" + Thread.currentThread().getName() + "-" + System.currentTimeMillis());
    }

}
