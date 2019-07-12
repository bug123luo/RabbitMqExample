package com.lcclovehww.balking;

/**
 * @author lcc
 * @date 2019/7/12 - 11:10
 */
public class BalkingMain {
    public static void main(String[] args){
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
