package com.lcclovehww.singleThreadedExecution;

import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/10 - 10:22
 */
public class UserThread extends Thread{

    private final static Random random = new Random(26535);
    private final BoundedResourece resource;

    public UserThread(BoundedResourece resource){
        this.resource = resource;
    }

    public void run(){
        try{
            while (true){
                resource.use();
                Thread.sleep((random.nextInt(3000)));
            }
        }catch (InterruptedException e){

        }
    }
}
