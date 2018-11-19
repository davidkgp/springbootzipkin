package com.test.tracing.student.connector.zipkin;

import com.test.dto.Address;
import com.test.dto.Discipline;
import com.test.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentConnector {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public Student getStudent(String id) {
        return new Student(id,"Sachin"
                ,restTemplate.getForEntity("http://localhost:9077/student/address/"+id, Address.class).getBody()
                ,restTemplate.getForEntity("http://localhost:9078/student/discipline/"+id, Discipline.class).getBody());
    }
}
