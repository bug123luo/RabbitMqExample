package com.lcclovehww;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lcc
 * @date 2019/6/24 - 18:06
 */
public class RabbitConsumer {

    public static final String QUEUE_NAME = "queue_demo";
    public static final String IP_ADDRESS = "192.168.0.123";
    public static final int PORT= 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("root123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message: "+new String(body));
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
