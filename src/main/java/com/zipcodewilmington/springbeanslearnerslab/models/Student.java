package com.zipcodewilmington.springbeanslearnerslab.models;

import com.zipcodewilmington.springbeanslearnerslab.repositories.Learner;

import javax.persistence.Entity;

@Entity
public class Student extends Person implements Learner {

    double numOfHours = 0;

    public Student(Long id, String name) {
        super(id, name);
    }

    @Override
    public void learn(double numberOfHours) {
        this.numOfHours += numberOfHours;
    }

    public double getNumOfHours() {
        return numOfHours;
    }
}
