import event.Concert;
import event.Event;
import event.Movie;
import event.Theatre;
import location.Arena;
import location.Cinema;
import location.Location;
import location.TheatreLoc;
import java.util.ArrayList;

public class Db {
    private int noOfEvents;

    private ArrayList<Location> locations;
    private ArrayList<Event> events1;


    public Db() {
        this.noOfEvents = 0;
        this.locations = new ArrayList<Location>();
        this.events1 = new ArrayList<Event>();

    }


    public ArrayList<Location>getLocations() {
        return locations;

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
