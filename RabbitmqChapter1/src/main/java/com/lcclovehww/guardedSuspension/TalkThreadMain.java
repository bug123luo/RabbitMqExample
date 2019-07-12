package com.lcclovehww.guardedSuspension;

/**
 * @author lcc
 * @date 2019/7/11 - 11:28
 */
public class TalkThreadMain {
    public static void main(String[] args) {
        RequestQueue requestQueue1 =  new RequestQueue();
        RequestQueue requestQueue2 = new RequestQueue();
        new TalkThread(requestQueue1, requestQueue2, "Alice").start();
        new TalkThread(requestQueue2, requestQueue1,"Bobby").start();
    }
}
