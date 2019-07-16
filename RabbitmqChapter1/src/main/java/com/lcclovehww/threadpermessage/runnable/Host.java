package com.lcclovehww.threadpermessage.runnable;

/**
 * @author lcc
 * @date 2019/7/15 - 16:58
 */
public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println(" request("+count+", "+c+") BEGIN");
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        ).start();
    }
}
