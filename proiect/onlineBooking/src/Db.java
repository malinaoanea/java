import event.Concert;
import event.Event;
import event.Movie;
import event.Theatre;
import location.Arena;
import location.Cinema;
import location.Location;
import location.TheatreLoc;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Scanner;

public class Db {
    private Event[] events;
    private int noOfEvents;
    private int maxCapacity = 10;

    private Arena[] arenas;
    private int nArenas, nCinemas, nTheaters;
    private Cinema[] cinemas;
    private TheatreLoc[] theatreLocs;
    private int nLocation;
    private ArrayList<Location> locations;
    private ArrayList<Event> events1;


    public Db() {
        this.events = new Event[10];
        this.noOfEvents = 0;
        this.arenas = new Arena[3];
        this.nArenas = 0;
        this.nCinemas = 0;
        this.nTheaters = 0;
        this.cinemas = new Cinema[3];
        this.theatreLocs = new TheatreLoc[3];
        this.locations = new ArrayList<Location>();
        this.events1 = new ArrayList<Event>();
        this.nLocation = 0;
    }

    public boolean checkForArena(String arena) {
        if(nArenas == 0)
            return false;
        for(int i = 0 ; i < nArenas; i++) {
            if(this.arenas[i]!=null) {
                Location location = (Location) this.arenas[i];
                if (((Location) location).getName() == arena)
                    return true;
            }
        }
        return false;
    }

    public ArrayList<Location>getLocations() {
        return locations;

    }

    public Location checkForLocation(Location location) {
        //returns  the location if it exists; otherwise adds the location and returns it
        for( Location location1:this.locations ) {
            if( location.equals(location1) )
                return location1;
        }

        this.locations.add(location);

        return location;
    }

    public Event checkForEvent1(Event event) {
        //returns  the event if it exists; otherwise adds the event and returns it
        for( Event event2:this.events1 ) {
            if( event.equals(event2) )
                return event;
        }

        this.events1.add(event);

        return event;
    }

    public Event checkForEvent(String eventName) {
        for(int i = 0; i < this.noOfEvents; i++) {
            if(events[i] != null)
            if( this.events[i].getName() == eventName )
                return this.events[i];
        }
        return null;
    }

    public void printEvents() {
        String str = "Events are ";

        for(Event e:events1)
            if(e!=null){
                str += ( e + " // " );
        }
        System.out.println(str);
    }

    public Location getLoc(String loc) {
        for(Location loc1:locations) {
            if(loc1.getName() == loc) {
                return loc1;
            }
        }
        return null;
    }

    public Event getEvent(String event) {
        for(Event ev:events1) {
            if(ev.getName() == event) {
                return ev;
            }
        }
        return null;
    }

    public Location searchLocation(String loc) {
        for( Location l:locations ) {
            if ( l.getName() == loc  )
                return l;
        }
        return null;
    }

    public Event searchForEvent(String event) {
        for( Event ev:events1) {
            if( ev.getName() == event )
                return ev;
        }
        return null;
    }

    public void addConcert(String name, String date, String locationName) {
        Arena l = (Arena)this.searchLocation(locationName);
        if(l == null) {
            Arena arena = new Arena(locationName);
            this.locations.add( arena );
            l = arena;
        }

        Concert c = (Concert)this.searchForEvent(name);
        if(c == null) {
            Concert concert = new Concert(name,l, ++noOfEvents );
            this.events1.add( concert );
            c = concert;
        }

        l.updateTimetable(c, date);
        c.addArena(l);


    }

    public void addTheatre(String name, String date, String locationName) {
        TheatreLoc l = (TheatreLoc) this.searchLocation(locationName);
        if(l==null) {
            TheatreLoc theatreLoc = new TheatreLoc(locationName, 5);
            this.locations.add(theatreLoc);
            l = theatreLoc;
        }

        Theatre t = (Theatre)this.searchForEvent(name);
        if(t == null) {
            Theatre theatre = new Theatre(name, l, ++noOfEvents);
            this.events1.add(theatre);
            t = theatre;
        }

        l.updateTimetable(t, date);
        t.addTheatreLoc(l);


    }

    public void addMovie(String name, String date, String locationName) {
        Cinema l = (Cinema) this.searchLocation(locationName);
        if(l==null) {
            Cinema cinema = new Cinema(locationName, 5);
            this.locations.add(cinema);
            l = cinema;
        }

        Movie t = (Movie) this.searchForEvent(name);
        if(t == null) {
            Movie movie = new Movie(name, l, ++noOfEvents);
            this.events1.add(movie);
            t = movie;
        }

        l.updateTimetable(t, date);
        t.addCinema(l);


    }

    public void printEvents1() {
        String str = "Events are ";
        for(Event ev:events1) {
            str += ( ev + " // " );
        }
        System.out.println(str);
    }

    public  void addEvent(String name, String date, String locationName, String typee) {
        //for event add the new location
        //for location update the timetable with the specific date
        //there are no concerts, theaters or movies with the same name
        //same for locations


        if( typee == "concert" ) {
            this.addConcert(name, date, locationName);
            return;

        }
        if( typee == "teatru" ) {
            this.addTheatre(name, date, locationName);
            return;
        }
        if(typee == "movie") {
            this.addMovie(name, date, locationName);
            return;
        }
        System.out.println("Wrong type for " + name + " taking place at " + locationName + " on " + date);

    }


}
