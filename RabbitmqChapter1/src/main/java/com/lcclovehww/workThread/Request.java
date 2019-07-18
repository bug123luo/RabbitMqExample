package com.lcclovehww.workThread;

import java.util.Random;

/**
 * @author lcc
 * @date 2019/7/18 - 14:25
 */
public class Request {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " execute " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "[ Request from " + name + "No." + number + " ]";
    }
}
