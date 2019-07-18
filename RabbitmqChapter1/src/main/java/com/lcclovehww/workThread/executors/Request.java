package com.lcclovehww.workThread.executors;

import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/18 - 15:00
 */
public class Request implements Runnable{
    private final String name; //委托者
    private final int number; //请求编号
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" execute "+this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "[ Request from " + name + " No." + number + " ] ";
    }
}