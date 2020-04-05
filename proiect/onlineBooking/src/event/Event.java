package event;

import location.Location;
import location.TheatreLoc;

import javax.print.DocFlavor;

public class Event {
    private int indxEvent = 0;
    private int noOfRepr;
    private String name;

    public Event(String denumire, int index) {
        this.indxEvent = index;
        this.noOfRepr = 1;
        this.name = denumire;
    }

    public int getIndxEvent() {
        return indxEvent;
    }

    public int getNoOfRepr() {
        return noOfRepr;
    }

    public void addRepr() {
        noOfRepr += 1;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public Location[] getLocation() {
        return null;
    }

    public Location checkForLocation(String arenaName){return null;}

    public void bookForLocation(String eventName, String Location, int nTickets) {return;}
    public void unbookForLocation(String eventName, String Location, int nTickets) {return;}

}
