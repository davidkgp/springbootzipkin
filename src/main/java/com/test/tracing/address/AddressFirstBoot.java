package com.test.tracing.address;

import com.test.dto.Address;
import com.test.tracing.address.repo.AddressRepo;
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
public class AddressFirstBoot {

    private final Logger LOG = LoggerFactory.getLogger(AddressFirstBoot.class);

    @Autowired
    AddressRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(AddressFirstBoot.class,"--spring.application.name='AddressApp'","--server.port=9077");
    }

    @GetMapping("/student/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable("id") String id){
        Address address = repo.getAddress(id);
        return address!=null?new ResponseEntity<>(address, HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
