package com.zipcodewilmington.springbeanslearnerslab.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class People <PersonType extends Person> implements Iterable<PersonType> {

   private List<PersonType> peopleList;

    public People() {
        peopleList = new ArrayList<>();
    }

    public People(List<PersonType> personList) {
        peopleList = new ArrayList<>();
        this.peopleList = personList;
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
        this.peopleList.clear();
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

    public List<PersonType> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<PersonType> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public Iterator<PersonType> iterator(){
        return peopleList.iterator();
    }
}
