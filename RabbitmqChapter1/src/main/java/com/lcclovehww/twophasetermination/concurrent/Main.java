package com.lcclovehww.twophasetermination.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lcc
 * @date 2019/7/18 - 10:53
 */
public class Main {
    private static final int TASKS = 10;

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch downLatch = new CountDownLatch(TASKS);

        try {
            //开始工作
            for (int t = 0; t < TASKS; t++) {
                service.execute(new MyTask(downLatch, t));
            }
            System.out.println("AWAIT");
            //等待工作结束
            downLatch.await();
        } catch (InterruptedException e){

        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
