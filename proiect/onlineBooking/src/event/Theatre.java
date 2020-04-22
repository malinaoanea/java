package event;

import location.Location;
import location.TheatreLoc;

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

    public void addTheatreLoc(TheatreLoc theatreLoc) {
        if(n < 3) this.theatre[n++] = theatreLoc;
        else System.out.println("Too many theatres for " + super.toString());

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
