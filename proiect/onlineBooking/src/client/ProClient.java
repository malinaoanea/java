package client;

import event.Event;

import java.util.ArrayList;

//client who has gets for each three booked tickets one free
public class ProClient extends Person {
    private ArrayList<Event> events;
    private int  n = 0;

    public ProClient(String name, String CNP) {
        super(name,  CNP);
        events = new ArrayList<Event>();
    }

    public ProClient(String name, String CNP, String id) {
        super(name,  CNP, id);
        events = new ArrayList<Event>();
    }

    public ArrayList<Event> getEvent() {
        return events;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public void addEvent(Event event) {
        this.events.add(event);
        this.n++;

        if( n == 3 ) {
            this.n = 0;
            System.out.println(this.getName() + " has won one extra ticket for " + event);
            this.events.add(event);
        }
    }

    @Override
    public ArrayList<Event> getEvents() {
        return events;
    }

//    @Override
//    protected String toCSV() {
//        return super.toCSV() + ',' + n;
//    }
}
