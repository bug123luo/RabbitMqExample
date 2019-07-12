package com.lcclovehww.guardedSuspension;

import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/11 - 11:06
 */
public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue, String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run(){
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No."+i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){}
        }
    }
}
