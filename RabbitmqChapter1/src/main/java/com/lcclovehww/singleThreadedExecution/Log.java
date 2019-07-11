package com.lcclovehww.singleThreadedExecution;

/**
 * @author lcc
 * @date 2019/7/10 - 10:23
 */
public class Log {

    public static void println(String s){
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}
