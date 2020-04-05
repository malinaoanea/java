package event;

import location.Arena;
import location.Location;
import location.TheatreLoc;

public class Concert extends Event {
    private Arena[] arena;
    private int n;

    public Concert(String denumire, Arena arena, int index ) {
        super( denumire, index);
        this.arena = new Arena[3];
        this.arena[0] = arena;
        this.n = 1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :  " + super.toString();
    }

    @Override
    public Location[] getLocation() {
        return arena;
    }

    @Override
    //returns the arena if found, else returns null
    public Arena checkForLocation(String arenaName) {
        for(Arena a:arena) {
            if (a != null) {

                if (arenaName == a.getName())
                    return a;
            }
        }

        return null;


    }

    public void addArena(Arena a) {
        if (n < 3) this.arena[n++] = a;
        else System.out.println("Too many arenas for " + super.toString());
    }

    @Override
    public boolean bookForLocation(String eventName, String location, int nTickets) {
        Arena a = this.checkForLocation(location);

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
        Arena a = this.checkForLocation(location);

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
