package com.lcclovehww;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lcc
 * @date 2019/6/26 - 16:45
 */
public class RabbitTopicProducer {

    public static final String EXCHANGE_NAME="topic_exchange_demo";
    public static final String Binding_KEY = "*.rabbitmq.*";
    public static final String Binding_KEY2 = "*.*.client";
    public static final String Binding_KEY3 = "com.#";
    public static final String ROUTING_KEY = "com.rabbitmq.client";
    public static final String ROUTING_KEY2 = "com.hidden.client";
    public static final String ROUTING_KEY3 = "com.hidden.demo";
    public static final String ROUTING_KEY4 = "java.rabbitmq.demo";
    public static final String ROUTING_KEY5 = "java.util.concurrent";
    public static final String QUEUE_NAME = "topic_queue_demo_1";
    public static final String QUEUE_NAME2 = "topic_queue_demo_2";
    //    public static final String IP_ADDRESS = "192.168.0.123";
    public static final String IP_ADDRESS = "218.17.140.132";
    public static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("root");
        factory.setPassword("root123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"topic", true, false,null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueDeclare(QUEUE_NAME2, true, false, false, null);
        channel.queueBind(QUEUE_NAME2,EXCHANGE_NAME, Binding_KEY);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, Binding_KEY2);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, Binding_KEY3);
        String message = "Hello World!";
        String message2 = "Hello World!!";
        String message3 = "Hello World!!!";
        String message4 = "Hello World!!!!";
        String message5 = "Hello World!!!!!";
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY2, MessageProperties.PERSISTENT_TEXT_PLAIN, message2.getBytes());
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY3, MessageProperties.PERSISTENT_TEXT_PLAIN, message3.getBytes());
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY4, MessageProperties.PERSISTENT_TEXT_PLAIN, message4.getBytes());
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY5, MessageProperties.PERSISTENT_TEXT_PLAIN, message5.getBytes());
        channel.close();
        connection.close();
    }
}
