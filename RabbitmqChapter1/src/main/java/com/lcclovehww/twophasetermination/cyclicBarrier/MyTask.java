package com.lcclovehww.twophasetermination.cyclicBarrier;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lcc
 * @date 2019/7/18 - 11:24
 */
public class MyTask implements Runnable {
    private static final int PHASE = 5;
    private final CyclicBarrier phaseBarrier;
    private final CountDownLatch downLatch;
    private final int context;
    private static final Random random = new Random(314159);

    public MyTask(CyclicBarrier phaseBarrier, CountDownLatch downLatch, int context) {
        this.phaseBarrier = phaseBarrier;
        this.downLatch = downLatch;
        this.context = context;
    }

    public void run(){
        try {
            for (int phase = 0; phase < PHASE; phase++) {
                doPhase(phase);
                phaseBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            downLatch.countDown();
        }
    }


    protected void doPhase(int phase) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:BEGIN:context = " + context + ",phase = " + phase);
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name + ":MyTask:END:context = " + context + ",phase = " + phase);
        }
    }
}
