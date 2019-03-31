package com.zipcodewilmington.springbeanslearnerslab.configTests;

import com.zipcodewilmington.springbeanslearnerslab.config.StudentConfig;
import com.zipcodewilmington.springbeanslearnerslab.models.Student;
import com.zipcodewilmington.springbeanslearnerslab.models.Students;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class StudentConfigTest {
    @Autowired @Qualifier ("currentStudents")
    Students currentStudents;

    @Test
    public void currentStudentsSize() {

        int expectedSize = 26;
        Assert.assertEquals(expectedSize,currentStudents.getPeopleList().size());

    }

    @Test
    public void previousStudentsTest() {
        List<String> expectedCurrStudNames = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"));
        List<Student> expectedCurrStudsList = new ArrayList<>(26);


    }
}