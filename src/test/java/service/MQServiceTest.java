
package service;

import com.rj.model.Employee;
import com.rj.service.MQService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;


public class MQServiceTest {

    @Mock
    JmsTemplate jmsTemplate;
    @Mock
    JmsTemplate jmsTemplateQueue;
    @InjectMocks
    MQService mqService = new MQService();
    @Test
    public void sendMessgageSuccessScenario(){
        MockitoAnnotations.initMocks(this);
        //JmsTemplate jmsTemplate = mock(JmsTemplate.class);
        doNothing().when(jmsTemplate).convertAndSend(isA(String.class),isA(Employee.class));

        Employee employee = new Employee();
        mqService.sendMessage(employee, "temp");
        verify(jmsTemplate, times(1)).convertAndSend("temp", employee);
    }

}


