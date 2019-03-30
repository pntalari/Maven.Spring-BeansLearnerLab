package com.zipcodewilmington.springbeanslearnerslab.models;

import com.zipcodewilmington.springbeanslearnerslab.repositories.Learner;
import com.zipcodewilmington.springbeanslearnerslab.repositories.Teacher;

import java.util.List;

public class Classroom {

    private List<Instructors> instructorsList;
    private Iterable<? extends Learner> studentsList;

    public Classroom() {
    }

    public Classroom(List<Instructors> instructors, List<Learner> students) {
        this.instructorsList = instructors;
        this.studentsList = students;
    }

    private void hostLecture(Teacher teacher, double numberOfHours){
        teacher.lecture(studentsList,numberOfHours);
    }

    public List<Instructors> getInstructorsList() {
        return instructorsList;
    }

    public Iterable<? extends Learner> getStudentsList() {
        return studentsList;
    }
}
