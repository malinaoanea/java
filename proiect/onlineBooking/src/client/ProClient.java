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
        this.n++;

        if( n == 3 ) {
            this.n = 0;
            System.out.println(this.getName() + " has won one extra ticket for " + event);
            this.events.add(event);
        }
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
}
