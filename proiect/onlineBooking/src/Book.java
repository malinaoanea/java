import client.Client;
import client.Person;
import client.ProClient;
import event.Event;
import location.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    Db db;
    DBClients dbClients;

    public Book(Db db, DBClients db2) {
        this.db = db;
        dbClients = db2;
    }


    //prints dates at all locations where the event is AVAILABLE
    public void showDatesforEvent( String eventName ) {
        //Event event = db.checkForEvent1(new Event(eventName, 0));
        Event event = db.getEvent(eventName);
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
                 l.getEventAt( event );

            }
        }
        System.out.println(delim);
    }

    //books an event at a specific if possible ( there are enough tickets and the
    // event takes place at that location)
    public void bookEventLocation(String name, String locationName, int numberOfTickets) {
        //Event event = db.checkForEvent(name);
        Event event = db.getEvent(name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        event.bookForLocation(name, locationName, numberOfTickets);

    }

    public void showLocations() {
        String str = "Locations are ";
        ArrayList<Location> locations = db.getLocations();
        for(Location location:locations) {
            str += ( location.toString() + " // " );
        }
        System.out.println(str);
    }

    public void unbookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = db.getEvent(name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        event.unbookForLocation(name, locationName, numberOfTickets);
    }

    public void showLocationForEvent(String eventName) {
        //Event event = db.checkForEvent(eventName);
        Event event = db.getEvent(eventName);
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

//    public void showEventAtLocation(String location) {

//    }

    public void showEvents() {
        db.printEvents1();
    }

    public void showClients() {
        System.out.println(dbClients);
    }

    //when a client wants to register and buys a ticket
    public void clientBuys(String clientName, String cnp, String eventName, String locationName) {
        //checks if the client is in database, it it doesn't exist the new client is added
        //return to a pointer to it
        Person person = dbClients.searchClient(clientName, cnp);

//        if( person instanceof Client) {
//            Client client = (Client) person;
            //Event event = db.checkForEvent(eventName);
        Event event = db.getEvent(eventName);
            if( event == null ) {
                System.out.println("Event " + eventName + " doesn't exists");
                return;
            }
            boolean book = event.bookForLocation(eventName, locationName, 1);

            if(book==true)
                person.addEvent(event);
//        }


    }



    public void showEventsForClient(String nume, String cnp) {
        Person client = dbClients.searchClient(nume, cnp);

        ArrayList<Event> events = ( (Client)client).getEvents();
        String str;
        if( client instanceof ProClient)
            str = "Events booked by " + nume + "(PRO CLIENT): ";
        else str = "Events booked by " + nume + "(Normal Client): ";


        for(Event event: events) {
                str += (event + " // ");

        }

        System.out.println(str);
    }


}
