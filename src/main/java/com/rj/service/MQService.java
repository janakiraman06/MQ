
package com.rj.service;

import com.rj.model.Employee;
import com.rj.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UncheckedIOException;

@Component
@Slf4j
public class MQService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    JmsTemplate prasad;

    public void sendMessage(Employee message, String topicDestination){
        try {
            log.info("Attempting Send message to Topic :" + topicDestination);
            jmsTemplate.convertAndSend(topicDestination, message);
            System.out.println(jmsTemplate.hashCode());
            System.out.println(prasad.hashCode());
        }
        catch (NullPointerException nullPointerException){
            throw new RuntimeException("null pointer");
        }
        catch (Exception e){
            log.error("Received Exception during send Message:" + e);
            //RuntimeException runtimeException = new RuntimeException();
            throw new RuntimeException("generic err");

        }
    }


    public void sendTo(String destination, Student student){
        prasad.convertAndSend(destination, student);
        log.info("Producer> Message Sent");
    }
}


