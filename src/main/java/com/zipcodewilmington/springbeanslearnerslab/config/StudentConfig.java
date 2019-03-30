package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Students;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class StudentConfig {
    Students currStudents;
    Students prevStudents;

    @Bean(name = "students")
    private Students currentStudents(){
        return this.currStudents;
    }

    @Bean(name = "previousStuds")
    private Students previousStudents(){
        return this.prevStudents;
    }
}
