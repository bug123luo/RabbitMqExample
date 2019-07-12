package com.lcclovehww.balking;

import java.io.IOException;
import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/12 - 11:07
 */
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run(){
        try {
            for (int i = 0; i < 10000; i++) {
                data.change("No."+i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
