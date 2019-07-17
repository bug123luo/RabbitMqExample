package com.lcclovehww.future.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lcc
 * @date 2019/7/17 - 10:43
 */
public class FutureData extends FutureTask<RealData> implements Data {

    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    public String getContent() throws ExecutionException{
        String string = null;
        try {
            string = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return string;
    }
}
