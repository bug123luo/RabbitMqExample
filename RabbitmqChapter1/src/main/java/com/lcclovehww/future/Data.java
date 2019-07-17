package com.lcclovehww.future;

import java.util.concurrent.ExecutionException;

/**
 * @author lcc
 * @date 2019/7/17 - 10:42
 */
public interface Data {
    public abstract String getContent() throws ExecutionException;
}
