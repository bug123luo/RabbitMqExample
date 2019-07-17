package com.lcclovehww.future;

/**
 * @author lcc
 * @date 2019/7/17 - 14:11
 */
public class Host {
    public Data request(final int count, final char c) {
        System.out.println(" request("+count+", "+c+") BEGIN");
        //[1]创建FutureData实例
        final FutureData future = new FutureData();
        //[2]启动一个新线程，用于创建RealData的实例
        new Thread(){
            public void run(){
                try {
                    RealData realData = new RealData(count, c);
                    future.setRealdata(realData);
                } catch (Exception e) {
                    future.setException(e);
                }

            }
        }.start();

        System.out.println(" request(" + count + ", " + c + ") END");
        //[3]返回FutureData的实例
        return future;
    }
}
