package database;

import CSVutils.Singletone;
import client.Client;
import client.Person;
import client.ProClient;
import event.Event;
import location.Location;
import services.EventServices;
import services.LocationServices;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Data {
    private ArrayList<Person> people;
    private ArrayList<Location> locations;
    private ArrayList<Event> events;
    private DataBaseHelper dataBaseHelper;
    private String auditFile = "audit.csv";

    public Data() {
        this.people = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.events = new ArrayList<>();
        this.dataBaseHelper = new DataBaseHelper();

    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void fetchData() {
        this.people = dataBaseHelper.getClients();
        this.locations = dataBaseHelper.getLocations();
        this.events = dataBaseHelper.getEvents(this.locations);
        dataBaseHelper.getevents_with_people(people, events);
    }

    public void showEvents() {
        String str = "Events are: ";
        for(Event ev:this.events) {
            str += ( ev + " // " );
        }
        System.out.println(str);
        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Showed events" + ',' + timeStamp +',' + currentThreadName, auditFile);

    }

    public void showLocations() {
        String str = "Locations are ";
        for(Location location:this.locations) {
            str += ( location.toString() + " // " );
        }
        System.out.println(str);
        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Showed locations" + ',' + timeStamp +',' + currentThreadName, auditFile);
    }

    public void addClient(String name, String CNP) {
        if (dataBaseHelper.checkForClient(people, CNP) == null) {
            dataBaseHelper.addClient(name, CNP);
            people.add(new Client(name, CNP, String.valueOf(people.size() + 1) ) );
        }

        else System.out.println(name + " already in database... :)");

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Added client" + ',' + name + "," + CNP + "," + timeStamp +',' + currentThreadName, auditFile);

    }



    public void bookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = this.dataBaseHelper.checkForEvent(events, name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        EventServices services = new EventServices(event);
        services.bookForLocation(name, locationName, numberOfTickets);

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Booked event" +  "," + event + "," + locationName + ',' + timeStamp +',' + currentThreadName, auditFile);

    }

    public Location[] showLocationForEvent(String eventName) {
        Event event = dataBaseHelper.checkForEvent(events, eventName);
        if( event == null ) {
            System.out.println("Event " + eventName + " doesn't exist");
            return null;
        }

        Location[] location = event.getLocation();
        String str = "Location for " + eventName + " are: ";
        for( Location l:location ) {
            if (l != null) {
                str += (l + " // ");

            }
        }

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Showed locations for event " + eventName + " " + location + ',' + timeStamp +',' + currentThreadName, auditFile);

        return location;
    }

    public String showEventsForClient(String nume, String cnp) {
        Person client = dataBaseHelper.checkForClient(people, cnp);
        if (client == null) {
            System.out.println("Client " + nume + " doesn't exist.");
            return "Client doesn't exist.";
        }
        ArrayList<Event> events = client.getEvents();
        System.out.println(events);
        String str;
        str = "Events booked by " + nume + "(Normal Client): ";


        for(Event event: events) {
            str += (event + " // ");

        }

        System.out.println(str);

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Showed events for client " + client +  ',' + timeStamp +',' + currentThreadName, auditFile);
        return str;
    }

    public void clientBuys(String clientName, String cnp, String eventName, String locationName) {
        //checks if the client is in database, if it doesn't exist the new client is added
        //returns a pointer to it
        Person person = dataBaseHelper.checkForClient(people, cnp);


        if (person == null) {
            // initially all clients are normal clients
            person = new Client(clientName, cnp, String.valueOf(people.size() + 1));
            people.add(person);
        }

        Event event =  dataBaseHelper.checkForEvent(events, eventName);
        if( event == null ) {
            System.out.println("Event " + eventName + " doesn't exists.");
            return;
        }

        EventServices eventServices = new EventServices(event);
        boolean book = eventServices.bookForLocation(eventName, locationName, 1);

        if(book==true) {
            person.addEvent(event);
            System.out.println(clientName + " booked ticket for " + eventName + " at "+ locationName);
            dataBaseHelper.addEvent_Client(person.getId(), event.getId(), 1);
        }


        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Client " + clientName + "  bought " +  "tickets at " + locationName +" ,"+ timeStamp +',' + currentThreadName, auditFile);

    }

    public void unbookEventLocation(String name, String locationName, int numberOfTickets) {
        Event event = dataBaseHelper.checkForEvent(events, name);
        if( event == null ) {
            System.out.println("Event " + name  + " doesn't exist");
            return;
        }

        EventServices eventServices = new EventServices(event);
        eventServices.unbookForLocation(name, locationName, numberOfTickets);

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Showed events" + ',' + timeStamp +',' + currentThreadName, auditFile);
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

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Showed DATES for " + eventName + ',' + timeStamp +',' + currentThreadName, auditFile);
    }

    public void addClient(String name, String CNP, int n) {
        if (dataBaseHelper.checkForClient(people, CNP) == null) {
            dataBaseHelper.addClient(name, CNP);
            people.add(new ProClient(name, CNP));
        }

        else System.out.println(name + " already in database... :)");

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Added client " + name+ ',' + timeStamp +',' + currentThreadName, auditFile);

    }

    public void showClients() {
        String str = "Clients are: ";

        for (Person client:people)
            str += ( client + ", ");

        System.out.println(str);

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Showed clients" + ',' + timeStamp +',' + currentThreadName, auditFile);
    }



    public  void  addEvent(String name, String date, String locationName, String type) {
        //for event add the new location
        //for location update the timetable with the specific date
        //there are no concerts, theaters or movies with the same name
        //same for locations
        dataBaseHelper.addEvent(name, date, locationName, type);

        if( type == "concert" ) {
            dataBaseHelper.addConcert(name, date, locationName, locations, events, String.valueOf(events.size() + 1));

        }
        else if( type == "theatre" ) {
            dataBaseHelper.addTheatre(name, date, locationName, locations, events, String.valueOf(events.size() + 1) );
        }
        else if(type == "movie") {
            dataBaseHelper.addMovie(name, date, locationName, locations, events, String.valueOf(events.size() + 1));
        }
        else System.out.println("Wrong type for " + name + " taking place at " + locationName + " on " + date);

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Added event " + name + ',' + timeStamp +',' + currentThreadName, auditFile);
    }

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public void deleteClient(String id) {
        Person person = dataBaseHelper.getClientWitID(people, id);

        dataBaseHelper.delete(id, "clients");
        people.remove(person);

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Removed client with id" + id + ',' + timeStamp +',' + currentThreadName, auditFile);

    }

    public void updateNameClient(String id, String newName) {
        Person person = dataBaseHelper.getClientWitID(people, id);
        dataBaseHelper.updateName(id, "clients", newName);

        person.setName(newName);

        String currentThreadName = Thread.currentThread().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Singletone.updateAudit("Removed client with id" + id + ',' + timeStamp +',' + currentThreadName, auditFile);
    }

}
