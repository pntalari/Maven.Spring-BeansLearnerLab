package com.zipcodewilmington.springbeanslearnerslab.configTests;

import com.zipcodewilmington.springbeanslearnerslab.config.StudentConfig;
import com.zipcodewilmington.springbeanslearnerslab.models.Student;
import com.zipcodewilmington.springbeanslearnerslab.models.Students;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
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

    @Autowired @Qualifier ("previousStudents")
    Students previousStudents;

    @Test
    public void StudentsSize() {
        int expectedPrevSize = 30;
        int expectedCurrentSize = 26;
        Assert.assertEquals(expectedCurrentSize,currentStudents.getPeopleList().size());
        Assert.assertEquals(expectedPrevSize,previousStudents.getPeopleList().size());
    }


    @Test
    public void currentStudentsTest() {
        List<String> expectedCurrStudNames = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"));
     //   List<String> expectedCurrStudsList = new ArrayList<>(expectedCurrStudNames);

        List<Student> actualCurrStudNames = currentStudents.getPeopleList();

        actualCurrStudNames.forEach(student -> Assert.assertTrue(expectedCurrStudNames.contains(student.getName())));

        //Assert.assertTrue(actualCurrStudNames.);
    }

    @Test
    public void previousStudentsTest() {
        List<String> expectedPrevStudNames = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                "22", "23", "24", "25", "26", "27", "28", "29", "30"));

        List<Student> actualPrevStudNames = previousStudents.getPeopleList();

        actualPrevStudNames.forEach(student -> Assert.assertTrue(expectedPrevStudNames.contains(student.getName())));

    }


}