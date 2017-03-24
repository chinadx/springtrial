package cn.goodman.business.main.controller;

import cn.goodman.SpringUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.bind.annotation.*;

import javax.jms.ConnectionFactory;

/**
 * Created by Shaun on 2017/1/18.
 */
@RestController
public class SampleController {

    @RequestMapping("/sample")
    @ResponseBody
    String home() {
        /**
         * 添加JMS的测试，使用ActiveMQ
         */
        System.out.println("Sending an email message.");
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        message.put("name", "John Smith");
        message.put("age", 34);
        JmsTemplate jmsTemplate = SpringUtils.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("mailbox", message);

        return "Hello World!";
    }

}
