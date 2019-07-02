package com.lcclovehww;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lcc
 * @date 2019/6/24 - 16:45
 */
public class RabbitProducer {

    public static final String EXCHANGE_NAME="exchange_demo";
    public static final String ROUTING_KEY = "routingkey_demo";
    public static final String ROUTING_KEY2 = "info";
    public static final String ROUTING_KEY3 = "debug";
    public static final String QUEUE_NAME = "queue_demo";
    public static final String QUEUE_NAME2 = "queue_demo2";
//    public static final String IP_ADDRESS = "192.168.0.123";
    public static final String IP_ADDRESS = "218.17.140.132";
    public static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("root");
        factory.setPassword("root123");
//        factory.setConnectionTimeout(60000);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"direct", true, false,null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueDeclare(QUEUE_NAME2, true, false, false, null);
        channel.queueBind(QUEUE_NAME2,EXCHANGE_NAME,ROUTING_KEY);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY2);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY3);
        String message = "Hello World!";
        String message2 = "Hello World!!";
        String message3 = "Hello World!!!";
        boolean mandatory = true;//true表示消息持久化 false表示消息非持久化
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, mandatory, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY2, mandatory, MessageProperties.PERSISTENT_TEXT_PLAIN, message2.getBytes());
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY3, mandatory, MessageProperties.PERSISTENT_TEXT_PLAIN, message3.getBytes());
        channel.close();
        connection.close();
    }
}
