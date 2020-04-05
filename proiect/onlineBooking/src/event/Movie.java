package event;

import location.Arena;
import location.Cinema;
import location.Location;
import location.TheatreLoc;

public class Movie extends Event {
    private Cinema[] cinema;
    private int n;

    public Movie(String denumire, Cinema cinema, int index) {
        super(denumire, index);
        this.cinema = new Cinema[3];
        this.cinema[0] = cinema;
        n = 1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :  " + super.toString();
    }

    @Override
    public Location[] getLocation() {
        return cinema;
    }

    public void addCinema(Cinema a) {
        if (n < 3) {
            this.cinema[n++] = a;
        }
        else {
            System.out.println("Too many cinemas for " + super.toString());
        }
    }
}

