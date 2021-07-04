package com.rj.amqlisteners;

import com.rj.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.rj.model.Student;

@Component
@Slf4j
public class MQListener {
    //@JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
    @JmsListener(destination = "MyFirstQueue", containerFactory = "jmsListenerContainerFactory")
    public void processQueue(Student student){
        log.info("Consumer>" + student);
    }

    @JmsListener(destination = "MyFirstTopic", containerFactory = "jmsListenerContainerFactoryTopic")
    public void processTopic(Employee employee){
        log.info("Consumer>" + employee);
    }

}

