package com.lcclovehww.GuardedSuspension;

/**
 * @author lcc
 * @date 2019/7/11 - 11:16
 */
public class GuardedSuspensionMain {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alice",3141592L).start();
        new ServerThread(requestQueue,"Bobby", 6535897L).start();
    }
}
