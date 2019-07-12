package com.lcclovehww.producerConsumer.concurrent;

import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/12 - 10:44
 */
public class EaterArrayBlockingQueueThread extends Thread{
    private final Random random;
    private final TableArrayBlockingQueue table;

    public EaterArrayBlockingQueueThread(String name, TableArrayBlockingQueue table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                String cake = table.take();
                Thread.sleep((random.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
