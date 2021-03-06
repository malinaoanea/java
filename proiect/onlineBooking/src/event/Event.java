package event;

import CSVutils.CSVutil;
import location.Location;

import java.util.Objects;

public class Event extends CSVutil {
//    private int indxEvent = 0;
    private int noOfRepr;
    private String name;
    private String id;

    public Event(String denumire, String id) {
//        this.indxEvent = index;
        this.noOfRepr = 1;
        this.name = denumire;
        this.id = id;
    }

    public String getId() {return id;}


    public int getNoOfRepr() {
        return noOfRepr;
    }

    public void addRepr() {
        noOfRepr += 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.id;
    }

    public String getName() {
        return name;
    }

    public Location[] getLocation() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(getName(), event.getName());
    }

    @Override
    protected String toCSV() {
        return name;
    }

    protected String getType() {
        return null;
    }
}
