package com.zipcodewilmington.springbeanslearnerslab.models;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Students extends People<Student> {

    public Students() {
    }

    public Students(List<Student> students) {
        super(students);
    }

}
