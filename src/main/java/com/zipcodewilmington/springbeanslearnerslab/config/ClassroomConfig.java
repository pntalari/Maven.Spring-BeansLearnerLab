package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ClassroomConfig {

    @Bean("currStudents")
    public Classroom currentCohort(){

        return new Classroom();
    }

    @Bean
    @DependsOn({"instructors", "students"})
    public Classroom previousCohort(){
        return new Classroom();

    }
}
