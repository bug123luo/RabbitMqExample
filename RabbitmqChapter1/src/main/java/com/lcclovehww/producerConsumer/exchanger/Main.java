package com.lcclovehww.producerConsumer.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author lcc
 * @date 2019/7/12 - 14:47
 */
public class Main {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<char[]>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];
        new ProducerExchangerThread(exchanger, buffer1, 314159).start();
        new ConsumerExchangerThread(exchanger, buffer2, 265358).start();
    }
}
