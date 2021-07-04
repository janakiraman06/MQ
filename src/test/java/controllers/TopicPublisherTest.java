package controllers;


import com.rj.controllers.TopicPublisher;
import com.rj.model.Employee;
import com.rj.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TopicPublisher.class)
public class TopicPublisherTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    TopicPublisher topicPublisher = new TopicPublisher();
    @Test
    public void sendMessageTopicControllerSuccessScenario(){
        MockitoAnnotations.initMocks(this);

        Employee employee = new Employee();

        employee.setName("Janakiraman");
        employee.setAge(29);


        doNothing().when(employeeService).sendMessage(isA(Employee.class));

        //topicPublisher.sendMessage(employee);
        Employee expected = employee;
        Employee actual=topicPublisher.sendMessage(employee);
        assertEquals(expected, actual);

        verify(employeeService, times(1)).sendMessage(employee);

    }
    /*
    @Test
    public void sendMessageTopicControllerExceptionScenario(){
        Employee employee2 = new Employee();
        employee2.setName("ab");
        employee2.setAge(29);
        Exception exception = assertThrows(RuntimeException.class, ()-> topicPublisher.sendMessage(employee2));
        String expectedMessage ="Invalid employee";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    */

    @Test
    public void validateEmployeeNameLengthFailScenario(){
        Employee employee = new Employee(29, "Ja");
        Exception exception = assertThrows(RuntimeException.class, () -> WhiteboxImpl.invokeMethod(topicPublisher, "validateEmployee",employee));
        String expected = "Invalid employee";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));
    }

}
