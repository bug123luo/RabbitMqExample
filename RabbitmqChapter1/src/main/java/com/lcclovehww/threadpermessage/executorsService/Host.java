package com.lcclovehww.threadpermessage.executorsService;

import java.util.concurrent.Executor;

/**
 * @author lcc
 * @date 2019/7/15 - 16:58
 */
public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        System.out.println(" request("+count+", "+c+") BEGIN");
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        );
        System.out.println(" request("+count+", "+c+") END");
    }
}
