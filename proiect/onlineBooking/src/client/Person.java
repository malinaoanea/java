package client;

import event.Event;
import CSVutils.*;

import java.io.BufferedReader;
import java.io.FileReader;


public class Person extends CSVutil {
    private String name;
    private String CNP;

    public String getName() {
        return name;
    }

    public Person(String name, String CNP ) {
        this.name = name;
        this.CNP = CNP;
    }

    public Person() {
    }

    public String getCNP() {
        return CNP;
    }

    @Override
    public String toString() {
        return this.name;
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

    @Override
    protected String getType() {
        return null;
    }

    @Override
    public void saveData(String fileName, String... data) {
        super.saveData(fileName);
    }


    @Override
    protected String toCSV() {
        return name + ',' + CNP;
    }


}
