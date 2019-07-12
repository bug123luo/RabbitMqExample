package com.lcclovehww.balking;

import java.io.IOException;

/**
 * @author lcc
 * @date 2019/7/12 - 11:05
 */
public class SaverThread extends Thread {
    private final Data data;
    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            while (true){
                data.save();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
