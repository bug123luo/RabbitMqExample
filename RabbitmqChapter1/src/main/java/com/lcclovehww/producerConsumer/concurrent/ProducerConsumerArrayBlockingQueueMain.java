package com.lcclovehww.producerConsumer.concurrent;

/**
 * @author lcc
 * @date 2019/7/12 - 10:48
 */
public class ProducerConsumerArrayBlockingQueueMain {
    public static void main(String[] args) {
        TableArrayBlockingQueue table = new TableArrayBlockingQueue(3);
        new MakerArrayBlockingQueueThread("MakerThread-1", table, 31415).start();
        new MakerArrayBlockingQueueThread("MakerThread-2", table, 92653).start();
        new MakerArrayBlockingQueueThread("MakerThread-3", table, 58979).start();
        new EaterArrayBlockingQueueThread("EaterThread-1", table, 32384).start();
        new EaterArrayBlockingQueueThread("EaterThread-2", table, 62643).start();
        new EaterArrayBlockingQueueThread("EaterThread-3", table, 38327).start();
    }
}
