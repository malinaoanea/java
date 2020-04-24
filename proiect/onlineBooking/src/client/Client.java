package client;

import event.Event;

import java.util.ArrayList;

public class Client extends Person {
    private ArrayList<Event> events;

    public Client() {
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public Client(String name, String CNP) {
        super(name,  CNP);
        events = new ArrayList<Event>();
    }

    public ArrayList<Event> getEvent() {
        return events;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    @Override
    protected String toCSV() {
        return super.toCSV();
    }
}
