package com.test.tracing.discipline;

import com.test.dto.Discipline;
import com.test.tracing.discipline.repo.DisciplineRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DisciplineFirstBoot {

    private final Logger LOG = LoggerFactory.getLogger(DisciplineFirstBoot.class);

    @Autowired
    DisciplineRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(DisciplineFirstBoot.class,"--spring.application.name='DisciplineApp'","--server.port=9078");
    }

    @GetMapping("/student/discipline/{id}")
    public ResponseEntity<Discipline> getDiscipline(@PathVariable("id") String id){
        Discipline discipline = repo.getDiscipline(id);
        return discipline!=null?new ResponseEntity<>(discipline, HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
