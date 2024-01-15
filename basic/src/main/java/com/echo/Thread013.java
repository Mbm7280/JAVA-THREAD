package com.echo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread013 {
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * 共享对象
     */
    class Res {
        private String userName;
        private char sex;
        private boolean flag;
    }


    /**
     * 写入线程
     */
    class Input extends Thread {
        private Res res;

        public Input(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            int count = 0;
            while (true) {
                synchronized (res) {
                    try {
                        if (res.flag) {
                            res.wait();
                            condition.wait();
                            condition.notify();
                        }
                        if (count == 0) {
                            res.userName = "余胜军";
                            res.sex = '男';
                        } else {
                            res.userName = "小薇";
                            res.sex = '女';
                        }
                        count = (count + 1) % 2;
                        res.flag = true;
                        // 唤醒我们的读的线程去读
                        res.notify();
                    } catch (Exception e) {

                    }

                }
            }
        }
    }

    /**
     * 读入线程
     */
    class Out extends Thread {
        private Res res;

        public Out(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
                try {
                    res.wait();
                    synchronized (res) {
                        //   if (res.flag==false) {
                        if (!res.flag) {
                            // 如果当前flag 对象值为falst情况下 释放当前cpu执行权 同时释放锁
                            res.wait();
                        }
                        System.out.println(res.userName + "," + res.sex);
                        res.flag = false;
                        res.notify();

                    }
                } catch (Exception e) {

                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread013().start();
    }

    public void start() throws InterruptedException {
        Res res = new Res();
        synchronized (res) {
            res.wait();
        }

        Input input = new Input(res);
        input.start();
        Out out = new Out(res);
        out.start();

        /**
         * 多线程 线程之间如何设置优先级
         * 线程如何用户、守护线程
         * join
         */
    }
}
