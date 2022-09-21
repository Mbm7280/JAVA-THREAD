package com.ehco.p1;

/**
 *  join()方法:
 *      作用：
 *              当有新的线程加入时，主线程会进入等待状态，一直到调用join()方法的线程执行结束为止
 *      底层：
 *              join()方法的底层是利用wait()方法实现的，，join方法是一个同步方法，当主线程调用t1.join()方法时，
 *              主线程先获得了t1对象的锁，随后进入方法，调用了t1对象的wait()方法，使主线程进入了t1对象的等待池，
 *              此时，A线程则还在执行，并且随后的t2.start()还没被执行，因此，B线程也还没开始。等到A线程执行完毕之后，
 *              主线程继续执行，走到了t2.start()，B线程才会开始执行。
 *
 *              只会调用wait方法，并没有在结束时调用notify，这是因为线程在die的时候会自动调用自身的notifyAll方法，来释放所有的资源和锁。
 */
public class Thread015 {

    static class ThreadJoin extends Thread {
        private String name;
        public ThreadJoin (String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(30);
                for(int i=1;i<=5;i++){
                    System.out.println(name+"-"+i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin t1 = new ThreadJoin("A");
        ThreadJoin t2 = new ThreadJoin("B");
        t1.start(); // t1.join()需要等t1.start()执行之后执行才有效果
        // t1.join(); // 此时A线程和B线程由交替执行 变为 B线程需要等A线程执行完毕之后才能执行
        t2.start();
        t1.join(); // 如果t1.join()放在t2.start()之后的话，仍然会是交替执行
    }

}
