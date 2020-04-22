package client;

import event.Event;

public class Person {
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
}
