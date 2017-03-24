package cn.goodman.mq;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * ConsumerA 和 ConsumerB用于消费消息队列，属于点到点的Queue模型的消息，A消费之后，B则收不到消息，反之亦然。
 * Created by Shaun on 2017/3/24.
 */
@Component
public class ConsumerA {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(JsonNode json) {
        System.out.println("Consumer A ... Received <" + json.toString() + ">");
    }
}
