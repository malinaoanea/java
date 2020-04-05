package event;

import location.Location;
import location.TheatreLoc;

import java.awt.print.Book;

public class Theatre extends Event {

    private TheatreLoc[] theatre;
    private int n;

    public Theatre(String denumire, TheatreLoc theatre, int index) {
        super(denumire, index);
        this.theatre = new TheatreLoc[3];
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :  " + super.toString();
    }

    @Override
    public Location[] getLocation() {
        return theatre;
    }

    @Override
    public void addRepr() {
        super.addRepr();
    }

    @Override
    public int getIndxEvent() {
        return super.getIndxEvent();
    }

    @Override
    public TheatreLoc checkForLocation(String theatreName) {
        for( TheatreLoc theatre1:theatre ) {
            if( theatre1 != null )
                if( theatre1.getName() == theatreName ) {
                    return theatre1;
                }
        }
        return null;

    }

    public void addTheatreLoc(TheatreLoc theatreLoc) {
        if(n < 3) this.theatre[n++] = theatreLoc;
        else System.out.println("Too many theatres for " + super.toString());

    }

    @Override
    public boolean bookForLocation(String eventName, String location, int nTickets) {
        TheatreLoc t = this.checkForLocation(location);

        if(t == null) {
            System.out.println(eventName + " doesn't take place at " + location);
            return false;
        }

        boolean booked = t.book(nTickets);

        if(booked == true) {
            System.out.println(n + " tickets booked for " + eventName + " taking place at "
                    + location);
            return true;
        }

        else {
            System.out.println("Couldn't book " + n + " tickets at " + eventName +
                    " taking place at " + location  + " // no tickets available");
            return false;
        }
    }

    @Override
    public void unbookForLocation(String eventName, String location, int nTickets) {
        TheatreLoc t = this.checkForLocation(location);

        if(t == null) {
            System.out.println(eventName + " doesn't take place at " + location);

        }

        boolean booked = t.unbook(nTickets);

        if(booked == true) {
            System.out.println(n + " tickets unbooked for " + eventName + " taking place at "
                    + location);

        }

        else {
            System.out.println("Couldn't book " + n + " tickets at " + eventName +
                    " taking place at " + location  + " // no tickets available");
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
