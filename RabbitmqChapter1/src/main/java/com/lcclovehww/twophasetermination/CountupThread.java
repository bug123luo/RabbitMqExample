package com.lcclovehww.twophasetermination;

/**
 * @author lcc
 * @date 2019/7/18 - 9:34
 */
public class CountupThread extends Thread {

    //计数值
    private long counter = 0;

    //发憷终止请求后变为true
    private volatile boolean shutdownRequested = false;

    //终止请求
    public void shutdownRequest(){
        shutdownRequested = true;
        interrupt();
    }

    //检查是否发出了终止请求
    public boolean isShutdownRequested(){
        return shutdownRequested;
    }

    //线程体
    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            doShutdown();
        }
    }

    //操作
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    //终止处理
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
