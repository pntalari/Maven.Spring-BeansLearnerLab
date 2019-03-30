package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {


    @Bean(name = "students")
     Students currentStudents(){
        return new Students();
    }

    @Bean(name = "previousStudents")
     Students previousStudents(){
        return new Students();
    }

}
