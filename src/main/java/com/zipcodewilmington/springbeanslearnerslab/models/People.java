package com.zipcodewilmington.springbeanslearnerslab.models;

import java.util.Iterator;
import java.util.List;

public abstract class People <PersonType extends Person> implements Iterable<PersonType> {

    List<PersonType> peopleList;

    public People(List<PersonType> personType) {
        this.peopleList = personType;
    }

    private void add(PersonType person){
        peopleList.add(person);
    }

    private void remove(PersonType person){
        peopleList.remove(person);
    }

    private int size(){
       return this.peopleList.size();
    }

    private void clear(){
        this.peopleList.removeAll(peopleList);
    }

    private void addAll(){
        peopleList.addAll(peopleList);
    }

    private Person findById(Long id){
        for (int i = 0; i <peopleList.size() ; i++) {
            if(peopleList.get(i).equals(id))
                return peopleList.get(i);
        }
        return null;
    }

    private List<PersonType> findAll(){
        return this.peopleList;
    }


}
