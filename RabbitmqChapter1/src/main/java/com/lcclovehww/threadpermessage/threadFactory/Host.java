package com.lcclovehww.threadpermessage.threadFactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author lcc
 * @date 2019/7/15 - 16:58
 */
public class Host {
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public Host(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char c) {
        System.out.println(" request("+count+", "+c+") BEGIN");
        threadFactory.newThread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        ).start();
        System.out.println(" request("+count+", "+c+") END");
    }
}
