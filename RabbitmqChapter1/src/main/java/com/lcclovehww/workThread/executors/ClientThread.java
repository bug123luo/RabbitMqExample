package com.lcclovehww.workThread.executors;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * @author lcc
 * @date 2019/7/18 - 14:55
 */
public class ClientThread extends Thread {
    private final ExecutorService executorsService;
    private static final Random random = new Random();

    public ClientThread(String name, ExecutorService executorsService) {
        super(name);
        this.executorsService = executorsService;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                executorsService.execute(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException e){
            e.printStackTrace();
        }
    }
}
