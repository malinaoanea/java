package event;

import location.Location;
import location.TheatreLoc;

public class Theatre extends Event {

    private TheatreLoc[] theatre;

    public Theatre(String denumire, TheatreLoc theatre, int index) {
        super(denumire, index);
        this.theatre = new TheatreLoc[3];
        this.theatre[0] = theatre;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :  " + super.toString();
    }

    @Override
    public Location[] getLocation() {
        return theatre;
    }
}
