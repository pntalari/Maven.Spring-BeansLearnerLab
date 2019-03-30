package com.zipcodewilmington.springbeanslearnerslab.models;

import com.zipcodewilmington.springbeanslearnerslab.repositories.Learner;
import com.zipcodewilmington.springbeanslearnerslab.repositories.Teacher;

import javax.persistence.Entity;
import java.util.Iterator;
import java.util.stream.StreamSupport;

@Entity
public class Instructor extends Person implements Teacher {

    public Instructor(Long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner leaner, double numberOfHours) {
        leaner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
         Long learnersCount = StreamSupport.stream(learners.spliterator(),false).count();
         double hrsPerLearner = numberOfHours / learnersCount;

         learners.forEach(learner -> learner.learn(hrsPerLearner));

    }
}
