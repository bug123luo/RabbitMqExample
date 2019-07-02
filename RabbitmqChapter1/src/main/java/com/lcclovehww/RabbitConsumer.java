package com.lcclovehww;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lcc
 * @date 2019/6/24 - 18:06
 */
public class RabbitConsumer {

    public static final String QUEUE_NAME = "queue_demo";
    public static final String QUEUE_NAME2 = "queue_demo2";

    //    public static final String IP_ADDRESS = "192.168.0.123";
    public static final String IP_ADDRESS = "218.17.140.132";
    public static final int PORT= 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("root123");
        Connection connection = factory.newConnection(addresses);
        Channel channel = connection.createChannel();
        try {
            channel.basicQos(64);
        }catch(ShutdownSignalException sse){//以下捕获的异常是为了判断这个Channel未关闭的问题
             sse.printStackTrace();
        }catch (SocketException se){
            se.printStackTrace();
        }catch (IOException is){
            is.printStackTrace();
        }

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
        channel.basicConsume(QUEUE_NAME2, consumer);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
