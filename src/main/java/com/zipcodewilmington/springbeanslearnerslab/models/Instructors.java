package com.zipcodewilmington.springbeanslearnerslab.models;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Instructors extends People<Instructor> {

    public Instructors(List<Instructor> instructors) {
        super(instructors);
    }

}
