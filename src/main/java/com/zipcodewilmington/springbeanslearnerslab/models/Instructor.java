package com.zipcodewilmington.springbeanslearnerslab.models;

import com.zipcodewilmington.springbeanslearnerslab.interfaces.Learner;
import com.zipcodewilmington.springbeanslearnerslab.interfaces.Teacher;

import javax.persistence.Entity;
import java.util.stream.StreamSupport;

@Entity
public class Instructor extends Person implements Teacher {

    private int numberOfHoursTought = 0;

    public Instructor(Long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner leaner, double numberOfHours) {
        leaner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        numberOfHoursTought +=numberOfHours;

         Long learnersCount = StreamSupport.stream(learners.spliterator(),false).count();
         double hrsPerLearner = numberOfHoursTought / learnersCount;

         learners.forEach(learner -> learner.learn(hrsPerLearner));

    }

    public int getNumberOfHoursTought() {
        return numberOfHoursTought;
    }
}
