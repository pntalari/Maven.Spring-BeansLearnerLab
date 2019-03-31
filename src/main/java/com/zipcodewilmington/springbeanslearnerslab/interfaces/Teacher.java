package com.zipcodewilmington.springbeanslearnerslab.interfaces;

public interface Teacher {

    public void teach(Learner leaner, double numberOfHours);

    public void lecture(Iterable<? extends Learner> learners,double numberOfHours);
}
