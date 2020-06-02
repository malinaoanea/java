package database;

import client.Client;
import client.Person;
import client.ProClient;
import event.Event;
import location.Location;
import services.EventServices;
import services.LocationServices;

import java.sql.Connection;
import java.util.ArrayList;

public class Data {
    private ArrayList<Person> people;
    private ArrayList<Location> locations;
    private ArrayList<Event> events;
    private DataBaseHelper dataBaseHelper;

    public Data() {
        this.people = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.events = new ArrayList<>();
        this.dataBaseHelper = new DataBaseHelper();
    }

    public void fetchData() {
        this.people = dataBaseHelper.getClients();
        this.locations = dataBaseHelper.getLocations();
        this.events = dataBaseHelper.getEvents(this.locations);
    }

    public void showEvents() {
        String str = "Events are: ";
        for(Event ev:this.events) {
            str += ( ev + " // " );
        }
        System.out.println(str);
    }

    public void showLocations() {
        String str = "Locations are ";
        for(Location location:this.locations) {
            str += ( location.toString() + " // " );
        }
        System.out.println(str);
    }

    public void addClient(String name, String CNP) {
        if (dataBaseHelper.checkForClient(people, CNP) == null) {
            dataBaseHelper.addClient(name, CNP);
            people.add(new Client(name, CNP));
        }

        else System.out.println(name + " already in database... :)");

    }

    public void bookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = this.dataBaseHelper.checkForEvent(events, name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        EventServices services = new EventServices(event);
        services.bookForLocation(name, locationName, numberOfTickets);

    }

    public void showLocationForEvent(String eventName) {
        Event event = dataBaseHelper.checkForEvent(events, eventName);
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

    public void unbookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = dataBaseHelper.checkForEvent(events, name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        EventServices eventServices = new EventServices(event);
        eventServices.unbookForLocation(name, locationName, numberOfTickets);
    }

    public void showDatesforEvent( String eventName) {
        Event event = dataBaseHelper.checkForEvent(events, eventName);
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

    public void addClient(String name, String CNP, int n) {
        if (dataBaseHelper.checkForClient(people, CNP) == null) {
            dataBaseHelper.addClient(name, CNP);
            people.add(new ProClient(name, CNP));
        }

        else System.out.println(name + " already in database... :)");

    }

    public void showClients() {
        String str = "Clients are: ";

        for (Person client:people)
            str += ( client + ", ");

        System.out.println(str);
    }



    public  void addEvent(String name, String date, String locationName, String type) {
        //for event add the new location
        //for location update the timetable with the specific date
        //there are no concerts, theaters or movies with the same name
        //same for locations
        dataBaseHelper.addEvent(name, date, locationName, type);

        if( type == "concert" ) {
            dataBaseHelper.addConcert(name, date, locationName, locations, events);

        }
        else if( type == "theatre" ) {
            dataBaseHelper.addTheatre(name, date, locationName, locations, events);
        }
        else if(type == "movie") {
            dataBaseHelper.addMovie(name, date, locationName, locations, events);
        }
        else System.out.println("Wrong type for " + name + " taking place at " + locationName + " on " + date);

    }

}
