package com.lcclovehww.GuardedSuspension;

/**
 * @author lcc
 * @date 2019/7/11 - 11:20
 */
public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;
    public TalkThread(RequestQueue input, RequestQueue output, String name){
        super(name);
        this.input = input;
        this.output = output;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " :BEGIN");
        for (int i = 0; i < 20; i++) {
            //接收对方的请求
            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);

            //加上一个感叹号(!)再返给对方
            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request2);
            output.putRequest(request2);
        }
        System.out.println(Thread.currentThread().getName() + ":END");
    }
}
