package com.lcclovehww.twophasetermination.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author lcc
 * @date 2019/7/18 - 10:47
 */
public class MyTask implements Runnable {
    private final CountDownLatch doneLatch;
    private final int context;
    private static final Random random = new Random(314159);

    public MyTask(CountDownLatch doneLatch, int context) {
        this.doneLatch = doneLatch;
        this.context = context;
    }

    public void run(){
        doTask();
        doneLatch.countDown();
    }

    protected void doTask() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:BEGIN:context = " + context);
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name + ":MyTask:END:context = " + context);
        }
    }
}
