import event.Event;
import location.Location;

import java.util.Scanner;

public class Book {
    Db db;

    public Book(Db db) {
        this.db = db;
    }

    //prints dates at all locations where the event is AVAILABLE
    public void showDatesforEvent( String eventName ) {
        Event event = db.checkForEvent(eventName);
        if( event == null ) {
            System.out.println("Event " + eventName + " doesn't exist");
            return;
        }

        Location[] location = event.getLocation();
        for( Location l:location ) {
            if( l != null ) {
                 l.getEventAt( event );

            }
        }
    }

    //books an event at a specific if possible ( there are enough tickets and the
    // event takes place at that location)
    public void bookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = db.checkForEvent(name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        event.bookForLocation(name, locationName, numberOfTickets);

    }

    public void unbookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = db.checkForEvent(name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        event.unbookForLocation(name, locationName, numberOfTickets);
    }

    public void showLocationForEvent(String eventName) {
        Event event = db.checkForEvent(eventName);
        if( event == null ) {
            System.out.println("Event " + eventName + " doesn't exist");
            return;
        }

        Location[] location = event.getLocation();
        String str = "Location for event are: ";
        for( Location l:location ) {
            if (l != null) {
                str += (l + " // ");

            }
        }

        System.out.println(str);
    }

    public void showEventAtLocation(String location) {

    }


}
