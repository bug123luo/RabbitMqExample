package com.lcclovehww.future;

import java.util.concurrent.ExecutionException;

/**
 * @author lcc
 * @date 2019/7/17 - 10:43
 */
public class FutureData implements Data{
    private RealData realdata = null;
    private boolean ready = false;
    private ExecutionException exception = null;

    public synchronized void setRealdata(RealData realdata) {
        if (ready) {
            return;
        }
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized void setException(Throwable throwable) {
        if (ready) {
            return;
        }
        this.exception = new ExecutionException(throwable);
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() throws ExecutionException{
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (exception != null){
            throw exception;
        }
        return realdata.getContent();
    }
}
