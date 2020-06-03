package event;

import location.Cinema;
import location.Location;

public class Movie extends Event {
    private Cinema[] cinemas;
    private int n;

    public Movie(String denumire, Cinema cinema, String index) {
        super(denumire, index);
        this.cinemas = new Cinema[3];
        this.n = 0;
    }

    @Override
    public String toString() {
        return super.toString() + "(" +  this.getClass().getSimpleName() + ")";
    }

    public Cinema[] getCinemas() {
        return cinemas;
    }

    public int getN() {
        return n;
    }

    @Override
    public Location[] getLocation() {
        return cinemas;
    }

    @Override
    protected String toCSV() {
        String string = super.toCSV();
        return  string;
    }

    @Override
    protected String getType() {
        return "movie";
    }

    public void addCinema(Cinema a) {
        if (n < 3) {
            this.cinemas[n++] = a;
        }
        else {
            System.out.println("Too many cinemas for " + super.toString());
        }
    }

}

