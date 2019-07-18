package com.lcclovehww.workThread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lcc
 * @date 2019/7/18 - 14:44
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            new ClientThread("Alice", executorService).start();
            new ClientThread("Bobby", executorService).start();
            new ClientThread("Chris", executorService).start();

            //等待大约5秒
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          executorService.shutdown();
        }


    }
}
