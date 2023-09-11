package com.example.collegeapp.models;

public class Subject {

    String name;
//    int noOfChap;

    public Subject(){
        //It is required
    }

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
