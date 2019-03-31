package com.zipcodewilmington.springbeanslearnerslab.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class AlumniTest {

    @Autowired
    Alumni alumni;

    @Autowired
    Instructors instructors;

    @Test
    public void executeBootCampTest() {

        int hoursToTeachEachStudent = 7200;
        int hoursEachStudLearned = 1200;

        Students students = alumni.getAlumStuds();

        instructors.forEach(instructor -> Assert.assertEquals(hoursToTeachEachStudent,instructor.getNumberOfHoursTought(),0));

        students.forEach(student -> Assert.assertEquals(hoursEachStudLearned,student.getNumOfHours(),0));
    }
}