package com.cdy.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Producer;

import javax.jms.*;

public class ActiveProducer {

    public static void  sendTextMessage(String message) {
        //连接工厂
        ConnectionFactory connectionFactory = null;
        //连接
        Connection connection = null;
        //目的地
        Destination destination =null;
        //会话
        Session session = null;
        //消息发送者
        MessageProducer messageProducer = null;
        //消息对象
        Message message1 = null;

        try {
            //创建工厂
            connectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://127.0.0.1:61616");
           //通过工厂创建连接
            connection = connectionFactory.createConnection();
            //消息的发送者不是必须启动连接，消息的消费者必须启动连接(建议启动连接)
            //producer 在发送消息时，会检测是否启动了连接，如果未启动，则自动启动
            connection.start();

            //通过连接对象，创建会话对象，必须绑定目的地
            /**
             * 创建会话的时候，必须传递两个参数，第一个代表是否支持事务，第二个代表如何确认消息处理
             * transacted 是否支持事务，数据类型是boolean true -支持  false-不支持
             * true  第二个参数默认是无效的，建议传递的数据是Session.SESSION_TRANSACTED
             * false 不支持事务，常用参数，第二个参数，必须传递，且必须有效
             *
             * acknowledgeMode  -如何确认消息的处理。使用确认机制实现的
             * AUTO_ACKNOWLEDGE   --自动确认消息，消息的消费者处理消息后，自动确认，常用
             * CLIENT_ACKNOWLEDGE   客户端手动确认，消息的消费者处理后，必须手工确认
             * DUPS_OK_ACKNOWLEDGE  有副本的客户端手动确认
             *    一个消息可以多次处理
             *    可降低session的消耗 也可以容忍重复消息时使用(不推荐使用)
             */
            session = connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);
            destination = session.createQueue("MQ");

            //通过会话创建消息的发送者   发送的消息一定制定到目的地中
            messageProducer = session.createProducer(destination);

            //创建文本消息对象，作为具体数据内容的载体
            message1 = session.createTextMessage(message);

            messageProducer.send(message1);
            System.out.println("发送成功！");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(messageProducer != null) {
                try {
                    messageProducer.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (session != null){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (connection !=null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        sendTextMessage("hello world");
    }
}
