package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Instructor;
import com.zipcodewilmington.springbeanslearnerslab.models.Instructors;
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
public class InstructorsConfigTest {

    @Autowired @Qualifier("usaInstructors")
    Instructors usaInstructors;
    @Autowired @Qualifier("ukInstructors")
    Instructors ukInstructors;
    @Autowired @Qualifier("instructors")
    Instructors zipInstructors;

    @Test
    public void instructorsSizeTest() {
        int expectedUSInstsLen = 5;
        int expectedUKInstsLen = 3;
        int expectedZipInstsLen = 5;

        Assert.assertEquals(expectedUSInstsLen,usaInstructors.getPeopleList().size());
        Assert.assertEquals(expectedUKInstsLen,ukInstructors.getPeopleList().size());
        Assert.assertEquals(expectedZipInstsLen,zipInstructors.getPeopleList().size());
    }

    @Test
    public void tcUSAInstructorsTest() {
        List<String> expUSInstsNames = new ArrayList<>(Arrays.asList("Bill","Ross","Monica","Joe","Rachael"));
        List<Instructor> actUSInstructors = usaInstructors.getPeopleList();

        actUSInstructors.forEach(instructorUSA -> Assert.assertTrue(expUSInstsNames.contains(instructorUSA.getName())));

    }

    @Test
    public void tcUKInstructorsTest() {
        List<String> expUKInstsNames = new ArrayList<>(Arrays.asList("Feeb","Chandler","Gunter"));
        List<Instructor> actUKInstructors = ukInstructors.getPeopleList();

        actUKInstructors.forEach(instructorUK -> Assert.assertTrue(expUKInstsNames.contains(instructorUK.getName())));

    }

    @Test
    public void zipinstructorsTest() {
        List<String> expZipInstsNames = new ArrayList<>(Arrays.asList("Nhu","Dolio","Kris","Leon","Froilan"));
        List<Instructor> actZipInstructors = zipInstructors.getPeopleList();

        actZipInstructors.forEach(instructor -> Assert.assertTrue(expZipInstsNames.contains(instructor.getName())));

    }

}