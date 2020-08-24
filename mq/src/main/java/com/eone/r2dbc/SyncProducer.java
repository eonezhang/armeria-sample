package com.eone.r2dbc;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-10:30 AM
 */
public class SyncProducer {
    public void sendMessage() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("huAppGroup");
        producer.setNamesrvAddr("10.121.31.58:9876");
        producer.setVipChannelEnabled(false);
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message message = new Message("TopicTest", "TagA", ("Hello RocketMQ " + i).getBytes());
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();
    }
}
