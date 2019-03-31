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

    int totalNumberOfHours = 1200;

    @PostConstruct
    public void executeBootCamp(){
        double numberOfHoursToTeach = totalNumberOfHours * alumStuds.getPeopleList().size();
        double numberOfHoursPerInstructor = numberOfHoursToTeach / alumStuds.getPeopleList().size();
        instructors.forEach(instructor -> instructor.lecture(alumStuds,numberOfHoursPerInstructor));
    }

    public Students getAlumStuds() {
        return this.alumStuds;
    }

    public Instructors getInstructors() {
        return this.instructors;
    }

}
