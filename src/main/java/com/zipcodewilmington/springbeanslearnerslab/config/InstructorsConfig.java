package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Instructor;
import com.zipcodewilmington.springbeanslearnerslab.models.Instructors;
import com.zipcodewilmington.springbeanslearnerslab.models.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Configuration
public class InstructorsConfig {

    private static List<Instructor> instructorsUSA = new ArrayList<>();
    private static List<String> instructorsUSANames = new ArrayList<>(Arrays.asList("Bill","Ross","Monica","Joe","Rachael"));

    private static List<Instructor> instructorsUK = new ArrayList<>();
    private static List<String> instructorsUKNames = new ArrayList<>(Arrays.asList("Feeb","Chandler","Gunter"));

    private static List<Instructor> instructorsZipCode = new ArrayList<>();
    private static List<String> instructorsZipNames = new ArrayList<>(Arrays.asList("Nhu","Dolio","Kris","Leon","Froilan"));


    @Bean(name = "usaInstructors")
    public Instructors tcUSAInstructors() {
        instructorsUSA = createInstructorsList(instructorsUSANames);
        return new Instructors(instructorsUSA);
    }

    @Bean(name = "ukInstructors")
    public Instructors tcUKInstructors() {
        instructorsUK = createInstructorsList(instructorsUKNames);
        return new Instructors(instructorsUK);
    }

    @Bean(name = "instructors")
    @Primary
    public Instructors instructors() {
        instructorsZipCode = createInstructorsList(instructorsZipNames);
        return new Instructors(instructorsZipCode);
    }

    public List<Instructor> createInstructorsList(List<String> instructorNames) {
        List<Instructor> retInstructorsList = new ArrayList<>(instructorNames.size());
        Iterator iterator = instructorNames.iterator();
        Long index = 0L;

        while (iterator.hasNext())
        {
            retInstructorsList.add(new Instructor(index, iterator.next().toString()));
            index++;
        }

        return retInstructorsList;
    }

}
