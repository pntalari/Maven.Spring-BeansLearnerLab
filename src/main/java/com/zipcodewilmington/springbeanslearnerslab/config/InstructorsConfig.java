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
public class InstructorsConfig<T> {

    private static List<Instructor> instructorsUSA = new ArrayList<>(4);
    private static List<String> instructorsUSANames = new ArrayList<>(Arrays.asList("Bill","Ross","Monica","Joe"));

    private static List<Instructor> instructorsUK = new ArrayList<>(4);
    private static List<String> instructorsUKNames = new ArrayList<>(Arrays.asList("Feeb","Chandler","Gunter","Shaun"));

    private static List<Instructor> instructorsZipCode = new ArrayList<>(6);
    private static List<String> instructorsZipNames = new ArrayList<>(Arrays.asList("Nhu","Will","Dolio","Kris","Leon","Froilan"));


    public List<Instructor> createInstructorsList(List<String> instructorNames) {
        List<Instructor> retInstructorsList = new ArrayList<>(instructorNames.size());
        Iterator iterator = instructorNames.iterator();
        Long index = 0L;

        while (iterator.hasNext()) {
            retInstructorsList.add(new Instructor(index, instructorNames.get(index.intValue())));
            index++;
        }

        return retInstructorsList;
    }

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

    @Bean(name = "zipInstructors")
    @Primary
    public Instructors instructors() {
        instructorsZipCode = createInstructorsList(instructorsZipNames);
        return new Instructors(instructorsZipCode);
    }


}
