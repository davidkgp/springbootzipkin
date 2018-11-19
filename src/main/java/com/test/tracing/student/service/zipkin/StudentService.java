package com.test.tracing.student.service.zipkin;

import com.test.dto.Student;
import com.test.tracing.student.connector.zipkin.StudentConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentConnector connector;

    public Student getStudent(String id) {
        return connector.getStudent(id);
    }
}
