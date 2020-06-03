package client;

import event.Event;
import CSVutils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;


public class Person  {
    private String name;
    private String CNP;
    private String id;

    public String getName() {
        return name;
    }

    public Person(String name, String CNP ) {
        // this will be called when a new client is being added
        this.name = name;
        this.CNP = CNP;
    }

    public Person(String name, String CNP, String id ) {
        this.name = name;
        this.CNP = CNP;
        this.id = id;
    }

    public Person() {
    }

    public  String getId() {return id;}

    public String getCNP() {
        return CNP;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.CNP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void addEvent(Event event) {
        return;
    }


//
//    @Override
//    public void saveData(String fileName, String... data) {
//        super.saveData(fileName);
//    }

//
//    @Override
//    protected String toCSV() {
//        return name + ',' + CNP;
//    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
                Objects.equals(getCNP(), person.getCNP());
    }


    public int hashCode() {
        return Objects.hash(getName(), getCNP());
    }

    public ArrayList<Event> getEvents() {
        return null;
    }
}
