package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Instructors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InstructorsConfig<T> {

    List<Instructors> instructorsUSA ;
    List<Instructors> instructorsUK;
    List<Instructors> instructors;

    private List<Instructors> combineInstructors(List<Instructors> instructorsUSA, List<Instructors> instructorsUK){
        this.instructors = new ArrayList<>();
        instructors.addAll(instructorsUK);
        instructors.addAll(instructorsUSA);

        return instructors;
    }

    @Bean(name = "usaInstructors")
    public List<Instructors> tcUSAInstructors(){
        instructorsUSA = new ArrayList<>();
        return this.instructorsUSA;
    }

    @Bean(name = "ukInstructors")
    public List<Instructors> tcUKInstructors(){
        instructorsUK = new ArrayList<>();
        return this.instructorsUK;
    }

    @Bean(name = "instructors")
    @Primary
    public List<Instructors> instructors(){
        return combineInstructors(this.instructorsUSA,this.instructorsUK);
    }

}
