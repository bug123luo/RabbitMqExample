package com.lcclovehww.producerConsumer.concurrent;

import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/12 - 10:38
 */
public class MakerArrayBlockingQueueThread extends Thread {
    private final Random random;
    private final TableArrayBlockingQueue table;
    private static int id = 0;

    public MakerArrayBlockingQueueThread(String name, TableArrayBlockingQueue table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
