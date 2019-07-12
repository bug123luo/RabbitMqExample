package com.lcclovehww.guardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lcc
 * @date 2019/7/11 - 11:00
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();
    public synchronized Request getRequest(){
        while (queue.peek() == null) {
            try {
                wait();
            }catch (InterruptedException e){

            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        notifyAll();
    }
}
