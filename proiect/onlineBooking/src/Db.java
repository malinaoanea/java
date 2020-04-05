import event.Concert;
import event.Event;
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

    public Arena getArena(String arena) {
        for(int i = 0 ; i < nArenas; i++) {
            Location location = (Location) this.arenas[i];
            if( ((Location)location).getName() == arena )
                return this.arenas[i];
        }
        System.out.println("Not good");
        return arenas[0];
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


//    public  void addEvent(String name, String date, String locationName, String typee) {
//
//        Event event = this.checkForEvent(name);
//
//
//        if( typee == "concert" ) {
//            boolean arenaAppears = this.checkForArena(locationName);
//            if( arenaAppears == true) {
//                //the location is already in the db => i only need to add the event to the timetable of that location
//                // !!!!!!!!! TRECI PRIN EVENT SA VEZI DACA EXISTA!!!!
//                Arena arena = this.getArena(locationName);
//
//                if(event == null) {
//                    Event ev = new Concert(name, arena, ++nArenas);
//                    this.events[noOfEvents++] = ev;
//                    ((Location) arena).updateTimetable(ev, date);
//                }
//
//                else
//                    ((Location)arena).updateTimetable(event, date);
//            }
//            else {
//                //the location doesn't exists
//                if ( this.nArenas < 3 ) {
//
//                    this.arenas[ this.nArenas++ ] = new Arena(locationName);
//                    if(event == null) {
//                        Event ev = new Concert(name, this.arenas[this.nArenas - 1], nArenas);
//                        this.events[noOfEvents++] = ev;
//                        ((Location) this.arenas[this.nArenas - 1]).updateTimetable(ev, date);
//
//                    }
//
//                    else
//                        ((Location) this.arenas[this.nArenas - 1]).updateTimetable(event, date);
//
//                }
//            }
//        }
//
//    }
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
        //se presupune ca un etatru nu are ace aceeasi denumire cu un cinema sau arena
//        Event event = new Event(name, ++noOfEvents );
//        Location location = new Location(locationName);
//
//
//        location = this.checkForLocation(location);
//        event = this.checkForEvent1(event);

        if( typee == "concert" ) {
            this.addConcert(name, date, locationName);

        }
        if( typee == "teatru" ) {
            this.addTheatre(name, date, locationName);
        }
        //System.out.println(location);

//        if( location == null ) {
//            if( nLocation < 5 ) {
//                if (typee == "concert")
//                    location = new Arena(locationName);
//                this.locations[nLocation++] = location;
//            }
//            else {
//                System.out.println("Too many locations!");
//                return;
//            }
//        }
//
//
//        if( event == null ) {
//            if ( noOfEvents <= 10 ) {
//                if (typee == "concert")
//                    event = new Concert(name, (Arena) location, ++noOfEvents);
//                this.events[noOfEvents - 1] = event;
//            }
//            else {
//                System.out.println("Too many events");
//                return;
//            }
//        }
//
//        if( typee == "concert") {
//            ((Concert)event).addArena( (Arena) location);
//            location.updateTimetable(event, date);
//        }

    }


}
