package cn.goodman.business.main.controller;

import cn.goodman.SpringContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

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
        JmsTemplate jmsTemplate = SpringContext.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("mailbox", message);

        return "Hello World!";
    }

}
