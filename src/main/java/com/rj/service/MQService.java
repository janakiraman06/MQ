
package com.rj.service;

import com.rj.model.Employee;
import com.rj.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MQService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    JmsTemplate jmsTemplateQueue;

    public void sendMessage(Employee message, String topicDestination){
        try {
            log.info("Attempting Send message to Topic :" + topicDestination);
            jmsTemplate.convertAndSend(topicDestination, message);
        }catch (Exception e){
            log.error("Received Exception during send Message:" + e);
        }
    }


    public void sendTo(String destination, Student student){
        jmsTemplateQueue.convertAndSend(destination, student);
        log.info("Producer> Message Sent");
    }
}


