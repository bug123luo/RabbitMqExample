package com.lcclovehww.singleThreadedExecution;

/**
 * @author lcc
 * @date 2019/7/10 - 9:45
 */
public class SemaphoreMain {

    public static void main(String[] args) {
        //设置3个资源
        BoundedResourece resource = new BoundedResourece(3);

        //使用10个线程使用资源
        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }
    }
}
