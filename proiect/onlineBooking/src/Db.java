import CSVutils.Singletone;
import event.*;
import location.*;
import services.LocationServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Db {
    private int noOfEvents;
    private ArrayList<Location> locations;
    private ArrayList<Event> events1;
    private String EventsFileName = "events.csv";
    private String LocationsFileName = "location.csv";


    public Db() {
        this.noOfEvents = 0;
        this.locations = new ArrayList<Location>();
        this.events1 = new ArrayList<Event>();
        // gets all the data from the csv files
        this.getData(EventsFileName);
        this.getData(LocationsFileName);
    }


    public ArrayList<Location>getLocations() {
        return locations;
    }

    public void getData(String FileName) {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader( new FileReader(FileName) );
            while ( (line = bufferedReader.readLine()) != null ) {
                String[] lineAt = line.split(",");
                if( FileName ==  EventsFileName){
                    if ( lineAt[lineAt.length - 1].equals("concert") ) {
                        this.addConcert(lineAt[0], lineAt[1], lineAt[2], true);
                    }
                    else if ( lineAt[lineAt.length - 1].equals("theatre")  ) {
                        this.addTheatre(lineAt[0], lineAt[1], lineAt[2], true);
                    }
                    else if( lineAt[lineAt.length - 1].equals("movie") ) {
                        this.addMovie(lineAt[0], lineAt[1], lineAt[2], true);
                    }
                    else {
                        System.out.println("Couldn't load into memory " + lineAt[0] +" from " + FileName + ".");
                    }
                }
                else if ( FileName == LocationsFileName ) {
                    int nr = 0;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No previous info in " + FileName +".");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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

    public void addConcert(String name, String date, String locationName, boolean... isInCSV) {
        // Bug to fix : cand adauga un eveniment nou, daca mai exista o data face o copie
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
        LocationServices locationServices = new LocationServices(l);
        locationServices.updateTimetable(c, date);
        c.addArena(l);

        // If the value is 0, then the object is loaded into Csv.
        // Otherwise, it is loaded from CSV into memory.
        if ( isInCSV.length == 0 )
            Singletone.writeData(c, EventsFileName, date, locationName, "concert");

    }

    public void addTheatre(String name, String date, String locationName, boolean... isInCSV) {
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

        LocationServices locationServices = new LocationServices(l);
        locationServices.updateTimetable(t, date);
        t.addTheatreLoc(l);
        // If the value is 0, then the object is loaded into Csv.
        // Otherwise, it is loaded from CSV into memory.
        if ( isInCSV.length == 0 )
            Singletone.writeData(t, EventsFileName, date, locationName, "theatre");

    }

    public void addMovie(String name, String date, String locationName, boolean... isInCSV) {
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

        LocationServices locationServices = new LocationServices(l);
        locationServices.updateTimetable(t, date);

        t.addCinema(l);
        // If the value is 0, then the object is loaded into Csv.
        // Otherwise, it is loaded from CSV into memory.
        if ( isInCSV.length == 0 )
            Singletone.writeData(t, EventsFileName, date, locationName, "movie");
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
