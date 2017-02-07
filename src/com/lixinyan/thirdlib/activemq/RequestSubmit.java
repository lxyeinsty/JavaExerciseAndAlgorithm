package com.lixinyan.thirdlib.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by administrator on 2016/5/28.
 *
 */
public class RequestSubmit {

    //消息发送者
    private MessageProducer messageProducer;
    //一个发送或者接受消息的线程
    private Session session;

    public void init() throws Exception {
        //ConnectionFactory连接工厂，JMS用它创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://127.0.0.1:61616");
        //Connection：JMS客户端到JMS Provider的连接，从构造工厂中得到连接对象
        Connection connection = connectionFactory.createConnection();
        //启动
        connection.start();
        //获取连接操作
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("RequestQueue");
        //得到消息生成（发送）者
        messageProducer = session.createProducer(destination);
        //设置不持久化
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
    }

    public void submit(HashMap<Serializable, Serializable> requestParam) throws JMSException {
        ObjectMessage message = session.createObjectMessage(requestParam);
        messageProducer.send(message);
        session.commit();
    }

    public static void main(String[] args) throws Exception {
        RequestSubmit requestSubmit = new RequestSubmit();
        requestSubmit.init();
        HashMap<Serializable,Serializable> requestParam = new HashMap<Serializable,Serializable>();
        requestParam.put("name", "lixinyan");
        requestSubmit.submit(requestParam);
    }
}
