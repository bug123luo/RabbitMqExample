package com.lcclovehww.producerConsumer.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lcc
 * @date 2019/7/12 - 14:27
 */
public class TableArrayBlockingQueue extends ArrayBlockingQueue<String> {
    public TableArrayBlockingQueue(int count) {
        super(count);
    }
    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " puts "+cake);
        super.put(cake);
    }

    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
