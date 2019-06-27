package com.lcclovehww;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lcc
 * @date 2019/6/26 - 16:44
 */
public class RabbitTopicConsumer {

    public static final String QUEUE_NAME = "topic_queue_demo_1";
    public static final String QUEUE_NAME2 = "topic_queue_demo_2";
    public static final String QUEUE_NAME3 = "first.mqtt";
    //    public static final String IP_ADDRESS = "192.168.0.123";
    public static final String IP_ADDRESS = "218.17.140.132";
    public static final int PORT= 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Address[] addresses = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        Channel channel = null;
        addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("root123");
        connection = factory.newConnection(addresses);
        channel = connection.createChannel();
        channel.basicQos(64);

        Channel finalChannel = channel;
        Consumer consumer = new DefaultConsumer(finalChannel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message: "+new String(body));
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finalChannel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(QUEUE_NAME3, consumer);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
