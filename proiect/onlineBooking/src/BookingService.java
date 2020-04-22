import client.Client;
import client.Person;
import event.Event;
import location.Location;
import services.LocationServices;
import services.EventServices;

import java.util.ArrayList;

public class BookingService {
    Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public BookingService(Book book) {
        this.book = book;
    }

    //prints dates at all locations where the event is AVAILABLE
    public void showDatesforEvent( String eventName ) {
        Event event = book.getDbLocalsEvents().getEvent(eventName);
        if( event == null ) {
            System.out.println("Event " + eventName + " doesn't exist");
            return;
        }
        String delim = "=======================================================";
        System.out.println(delim);
        System.out.println("Dates for " + eventName + " are: ");
        Location[] location = event.getLocation();
        for( Location l:location ) {
            if( l != null ) {
                LocationServices locationServices = new LocationServices(l);
                locationServices.getEventAt(event);
            }
        }
        System.out.println(delim);
    }

    //books an event at a specific if possible ( there are enough tickets and the
    // event takes place at that location)
    public void bookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = book.getDbLocalsEvents().getEvent(name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        EventServices services = new EventServices(event);
        services.bookForLocation(name, locationName, numberOfTickets);

    }

    public void showLocations() {
        String str = "Locations are ";
        ArrayList<Location> locations = book.getDbLocalsEvents().getLocations();
        for(Location location:locations) {
            str += ( location.toString() + " // " );
        }
        System.out.println(str);
    }

    public void unbookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = book.getDbLocalsEvents().getEvent(name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        EventServices eventServices = new EventServices(event);
        eventServices.unbookForLocation(name, locationName, numberOfTickets);
    }

    public void showEventsForClient(String nume, String cnp) {
        Person client = book.getDbClients().searchClient(nume, cnp);

        ArrayList<Event> events = ( (Client)client).getEvents();
        String str;
        str = "Events booked by " + nume + "(Normal Client): ";


        for(Event event: events) {
            str += (event + " // ");

        }

        System.out.println(str);
    }

    public void showEvents() {
        book.getDbLocalsEvents().printEvents1();
    }

    public void showClients() {
        System.out.println(book.getDbClients());
    }

    //when a client wants to register and buys a ticket
    public void clientBuys(String clientName, String cnp, String eventName, String locationName) {
        //checks if the client is in database, if it doesn't exist the new client is added
        //returns a pointer to it
        Person person = book.getDbClients().searchClient(clientName, cnp);

        Event event = book.getDbLocalsEvents().getEvent(eventName);
        if( event == null ) {
            System.out.println("Event " + eventName + " doesn't exists");
            return;
        }

        EventServices eventServices = new EventServices(event);
        boolean book = eventServices.bookForLocation(eventName, locationName, 1);

        if(book==true) {
            person.addEvent(event);
            System.out.println(clientName + " booked ticket for " + eventName + " at "+
                    locationName);
        }

    }

    public void showLocationForEvent(String eventName) {

        Event event = book.getDbLocalsEvents().getEvent(eventName);
        if( event == null ) {
            System.out.println("Event " + eventName + " doesn't exist");
            return;
        }

        Location[] location = event.getLocation();
        String str = "Location for " + eventName + " are: ";
        for( Location l:location ) {
            if (l != null) {
                str += (l + " // ");

            }
        }

        System.out.println(str);
    }


}
