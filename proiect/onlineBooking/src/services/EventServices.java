package services;

import event.Event;
import location.Arena;
import location.Cinema;
import location.Location;
import location.TheatreLoc;

public class EventServices {
    protected Event event;

    public EventServices(Event event) {
        this.event = event;
    }
    public EventServices(){};

    public Event getEvent() {
        return event;
    }

    public Location checkForLocation(String locationName){
        Location[] locations = event.getLocation();

        for ( Location location:locations ) {
            if( location != null ) {
                if( location.getName() == locationName )
                    return location;
            }
        }

        return null;
    }


    public boolean bookForLocation(String eventName, String locationName, int nTickets) {
        Location location = this.checkForLocation(locationName);

        if( location == null ) {
            System.out.println(eventName + " doesn't take place at " + location);
            return false;
        }

        boolean booked = false;
        if (location instanceof TheatreLoc)
            booked = ((TheatreLoc)location).book(nTickets);
        else if( location instanceof Arena)
            booked = ((Arena)location).book(nTickets);
        else if( location instanceof Cinema)
            booked = ((Cinema)location).book(nTickets);
        else {
            System.out.println("uita te in service NU E BINE");
        }

        if (booked == true) {
            System.out.println(nTickets + " tickets bought for " + eventName +" at " + locationName);
            return true;
        }
        else {
            System.out.println("Couldn't book "+ nTickets + " for " + eventName + " at " + locationName);
            return false;
        }
    }

    public void unbookForLocation(String eventName, String locationName, int nTickets) {
        Location location = this.checkForLocation(locationName);

        if (location == null ) {
            System.out.println(eventName + " doesn't take place at " + locationName);
        }

        else {
            boolean unbooked = false;
            if (location instanceof TheatreLoc)
                unbooked = ((TheatreLoc)location).unbook(nTickets);
            else if( location instanceof Arena)
                unbooked = ((Arena)location).unbook(nTickets);
            else if( location instanceof Cinema)
                unbooked = ((Cinema)location).unbook(nTickets);
            else {
                System.out.println("uita te in service NU E BINE");
                if (unbooked == true) {
                System.out.println(nTickets + " tickets unbooked for " + eventName + " taking place at "
                        + locationName);
            } else {
                System.out.println("Couldn't unbook " + nTickets + " tickets at " + eventName +
                        " taking place at " + locationName + " // there are not enough tickets booked");
                }
            }
        }
    }

}
