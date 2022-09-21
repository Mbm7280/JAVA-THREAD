package com.ehco.p1;

/**
 * 示例代码运行的时间作为比较结果  26毫秒
 * 添加Yield方法后，用时 23090毫秒
 * Thread.yield()方法作用是：
 *      暂停当前正在执行的线程对象（及放弃当前拥有的cup资源），
 *      并执行其他线程。yield()做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其
 *      他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 *      但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 *
 * 特点：
 *      调用了yield()方法后，线程依然处于RUNNABLE状态，线程不会进入堵塞状态。
 *
 * 使用场景：
 *      一般编程中用不到此方法，但在很多并发工具包中，yield()方法被使用，如AQS、ConcurrentHashMap、FutureTask等
 *
 * 面试题：
 *      yield()方法和sleep()方法有什么区别
 *      yield()方法调用后线程处于RUNNABLE状态，而sleep()方法调用后线程处于TIME_WAITING状态，
 *      所以yield()方法调用后线程只是暂时的将调度权让给别人，但立刻可以回到竞争线程锁的状态；而sleep()方法调用后线程处于阻塞状态。
 *
 */
public class Thread014 implements Runnable{
    @Override
    public void run() {
        long beginTimer = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 60000000; i++) {
            // Thread.yield(); // 添加Yield方法，将它让给其他任务去占用CPU执行时间
            count = count + (i + 1);
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("用时：" + (endTimer - beginTimer) + "毫秒;");
    }

    public static void main(String[] args) {
        new Thread(new Thread014()).start();
    }


}
