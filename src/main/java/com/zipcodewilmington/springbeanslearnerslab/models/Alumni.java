package com.zipcodewilmington.springbeanslearnerslab.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {
    @Autowired @Qualifier("previousStudents")
    Students alumStuds;

    @Autowired @Qualifier("instructors")
    Instructors instructors;

    int numberOfHoursToEachStud = 1200;

    @PostConstruct
    public void executeBootCamp(){
        int numberOfInstructors = instructors.getPeopleList().size();
        int numberOfStudents = alumStuds.getPeopleList().size();

        double numberOfHoursToTeach = numberOfHoursToEachStud * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;


        instructors.forEach(instructor -> instructor.lecture(alumStuds,numberOfHoursPerInstructor));
    }

    public Students getAlumStuds() {
        return this.alumStuds;
    }

    public Instructors getInstructors() {
        return this.instructors;
    }

}
