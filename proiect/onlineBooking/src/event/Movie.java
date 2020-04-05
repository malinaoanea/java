package event;

import location.Arena;
import location.Cinema;
import location.Location;

public class Movie extends Event {
    private Cinema[] cinemas;
    private int n;

    public Movie(String denumire, Cinema cinema, int index) {
        super(denumire, index);
        this.cinemas = new Cinema[3];
        this.n = 0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :  " + super.toString();
    }

    @Override
    public Location[] getLocation() {
        return cinemas;
    }

    @Override
    public Cinema checkForLocation(String cinemaName) {
        for(Cinema cinema:cinemas) {
            if(cinema!=null) {
                if(cinemaName == cinema.getName())
                    return cinema;
            }
        }
        return null;
    }

    public void addCinema(Cinema a) {
        if (n < 3) {
            this.cinemas[n++] = a;
        }
        else {
            System.out.println("Too many cinemas for " + super.toString());
        }
    }

    @Override
    public boolean bookForLocation(String eventName, String location, int nTickets) {
        Cinema a = this.checkForLocation(location);


        if( a == null ) {
            System.out.println(eventName + " doesn't take place at " + location);
            return false;
        }

        boolean booked = a.book(nTickets);

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
        Cinema a = this.checkForLocation(location);

        if( a == null ) {
            System.out.println(eventName + " doesn't take place at " + location);
            return;
        }

        boolean booked = a.unbook(nTickets);

        if(booked == true) {
            System.out.println(n + " tickets unbooked for " + eventName + " taking place at "
                    + location);
        }

        else {
            System.out.println("Couldn't unbook " + n + " tickets at " + eventName +
                    " taking place at " + location  + " // there are not enough tickets booked");
        }
    }
}

