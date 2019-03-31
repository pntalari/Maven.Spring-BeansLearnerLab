package com.zipcodewilmington.springbeanslearnerslab.config;

import com.zipcodewilmington.springbeanslearnerslab.models.Student;
import com.zipcodewilmington.springbeanslearnerslab.models.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Configuration
public class StudentConfig {

    private static List<Student> currentStudsList = new ArrayList<>(26);
    private static List<String> currentStudNames = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"));

    private static List<Student> previousStudsList = new ArrayList<>(30);
    private static List<String> previousStudNames = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
            "22", "23", "24", "25", "26", "27", "28", "29", "30"));

    public List<Student> createStudsList( List<String> studNames) {
        List<Student> retStudsList = new ArrayList<>(studNames.size());
        Iterator iterator = studNames.iterator();
        Long index = 0L;

        while (iterator.hasNext()) {
            retStudsList.add(new Student(index, studNames.get(index.intValue())));
            index++;
        }

        return retStudsList;

    }


    @Bean(name = "students")
    public Students currentStudents() {
        currentStudsList = createStudsList(currentStudNames);
        return new Students(currentStudsList);
    }

    @Bean(name = "previousStudents")
    public Students previousStudents() {

        previousStudsList = createStudsList(previousStudNames);
        return new Students(previousStudsList);
    }

}
