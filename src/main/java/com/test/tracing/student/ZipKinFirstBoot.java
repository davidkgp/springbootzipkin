package com.test.tracing.student;

import brave.sampler.Sampler;
import com.test.dto.Student;
import com.test.tracing.student.service.zipkin.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ZipKinFirstBoot {
    private final Logger LOG = LoggerFactory.getLogger(ZipKinFirstBoot.class);

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Autowired
    StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(ZipKinFirstBoot.class,"--spring.application.name='StudentApp'"
                ,"--server.port=8080");
                //,"--spring.sleuth.sampler.percentage=0.0");
    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String id){
        Student stud = service.getStudent(id);
        return stud!=null?new ResponseEntity<>(stud, HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
