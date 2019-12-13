package io.levi.baeldung.demo.springcloudstream.productor;

import io.levi.baeldung.demo.springcloudstream.schema.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AvroProducer {

    @Autowired
    private Processor processor;

    public void produceEmployeeDetails(int empId, String firstName, String lastName) {

        // creating employee details
        Employee employee = new Employee();
        employee.setId(empId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);

        Message<Employee> message = MessageBuilder.withPayload(employee)
                .build();

        processor.output()
                .send(message);
    }
}
