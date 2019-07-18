package com.lcclovehww.workThread;

import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/18 - 14:41
 */
public class ClientThread extends Thread{
    private final Channel channel;
    private static final Random random = new Random();

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run(){
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
