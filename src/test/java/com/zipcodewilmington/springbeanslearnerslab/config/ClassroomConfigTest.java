package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class ClassroomConfigTest {

    @Autowired
    @Qualifier("currCohort")
    Classroom currentCohort;

    @Autowired
    @Qualifier("instructors")
    Instructors instructors;

    @Autowired
    @Qualifier("currentStudents")
    Students currentStuds;

    @Autowired
    @Qualifier("prevCohort")
    Classroom previousCohort;

    @Autowired
    @Qualifier("previousStudents")
    Students previousStuds;


    @Test
    public void currentCohortTest() {

        Students expCurrStuds = currentStuds;

        List<Students> actCurrStuds = currentCohort.getStudentsList();

        Assert.assertEquals(expCurrStuds, actCurrStuds);

    }

    @Test
    public void previousCohortTest() {
        Students expPrevStuds = previousStuds;

        List<Students> actPrevStuds = previousCohort.getStudentsList();

        Assert.assertEquals(expPrevStuds, actPrevStuds);


    }
}