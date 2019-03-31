package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Classroom;
import com.zipcodewilmington.springbeanslearnerslab.models.Instructors;
import com.zipcodewilmington.springbeanslearnerslab.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class ClassroomConfig {

    @Bean("currCohort")
    @DependsOn({"instructors","currentStudents"})
    public Classroom currentCohort(List<Instructors> instructors, List<Students> students){

        return new Classroom(instructors,students);
    }

    @Bean("prevCohort")
    @DependsOn({"instructors", "previousStudents"})
    public Classroom previousCohort(List<Instructors> instructors,List<Students> students){
        return new Classroom(instructors,students);

    }
}
