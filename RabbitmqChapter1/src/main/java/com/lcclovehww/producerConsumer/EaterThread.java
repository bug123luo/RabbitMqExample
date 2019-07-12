package com.lcclovehww.producerConsumer;
import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/12 - 10:44
 */
public class EaterThread extends Thread{
    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table, long seed) {
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
