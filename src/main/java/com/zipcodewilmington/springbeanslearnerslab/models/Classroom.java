package com.zipcodewilmington.springbeanslearnerslab.models;

import com.zipcodewilmington.springbeanslearnerslab.repositories.Learner;
import com.zipcodewilmington.springbeanslearnerslab.repositories.Teacher;

import java.util.List;

public class Classroom {

    private List<Instructors> instructorsList;
    private List<Students> studentsList;

    public Classroom(List<Instructors> instructors, List<Students> students) {
        this.instructorsList = instructors;
        this.studentsList = students;
    }

    private void hostLecture(Teacher teacher, double numberOfHours){
        teacher.lecture((Iterable<? extends Learner>) studentsList,numberOfHours);
    }

    public List<Instructors> getInstructorsList() {
        return instructorsList;
    }

    public List<Students> getStudentsList() {
        return studentsList;
    }
}
