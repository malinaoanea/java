package event;

import location.Location;
import location.TheatreLoc;

import javax.print.DocFlavor;
import java.util.Objects;

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

    public boolean bookForLocation(String eventName, String Location, int nTickets) {return true;}

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(getName(), event.getName());
    }

    public void unbookForLocation(String eventName, String Location, int nTickets) {return;}

}
