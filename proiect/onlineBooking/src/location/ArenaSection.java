package location;

import java.io.Serializable;

public class ArenaSection {
    private String name;
    private int numberOfTckets;
    private int bookedTickets;

    public ArenaSection(String name, int numberOfTckets, int bookedTickets) {
        this.name = name;
        this.numberOfTckets = numberOfTckets;
        this.bookedTickets = bookedTickets;
    }

    public boolean chekForTickets(int n) {
        //checks if there are n tikets unbooked
        if(n + bookedTickets <= numberOfTckets) {
            return  true;
        }
        return false;
    }

    public void book(int n) {
        // books n tickets
        bookedTickets += n;
    }
}
