import event.Concert;
import event.Event;
import location.Arena;
import location.Cinema;
import location.Location;
import location.TheatreLoc;

import java.util.Scanner;

public class Db {
    private Event[] events;
    private int noOfEvents;
    private int maxCapacity = 10;

    private Arena[] arenas;
    private int nArenas, nCinemas, nTheaters;
    private Cinema[] cinemas;
    private TheatreLoc[] theatreLocs;
    private Location[] locations;


    public Db() {
        this.events = new Event[10];
        this.noOfEvents = 0;
        this.arenas = new Arena[3];
        this.nArenas = 0;
        this.nCinemas = 0;
        this.nTheaters = 0;
        this.cinemas = new Cinema[3];
        this.theatreLocs = new TheatreLoc[3];
        this.locations = new Location[5];
    }

    public boolean checkForArena(String arena) {
        if(nArenas == 0)
            return false;
        for(int i = 0 ; i < nArenas; i++) {
            Location location = (Location)this.arenas[i];
            if( ((Location)location).getName() == arena )
                return true;
        }
        return false;
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
            if( this.events[i].getName() == eventName )
                return this.events[i];
        }
        return null;
    }

    public void printEvents() {
        for(Event e:events) {
            System.out.println(e);
        }
    }


    public  void addEvent(String name, String date, String locationName, String typee) {

        Event event = this.checkForEvent(name);


        if( typee == "concert" ) {
            boolean arenaAppears = this.checkForArena(locationName);
            if( arenaAppears == true) {
                //the location is already in the db => i only need to add the event to the timetable of that location
                // !!!!!!!!! TRECI PRIN EVENT SA VEZI DACA EXISTA!!!!
                Arena arena = this.getArena(locationName);

                if(event == null) {
                    Event ev = new Concert(name, arena, ++nArenas);
                    this.events[noOfEvents++] = ev;
                    ((Location) arena).updateTimetable(ev, date);
                }

                else
                    ((Location)arena).updateTimetable(event, date);
            }
            else {
                //the location doesn't exists
                if ( this.nArenas < 3 ) {

                    this.arenas[ this.nArenas++ ] = new Arena(locationName);
                    if(event == null) {
                        Event ev = new Concert(name, this.arenas[this.nArenas - 1], nArenas);
                        this.events[noOfEvents++] = ev;
                        ((Location) this.arenas[this.nArenas - 1]).updateTimetable(ev, date);

                    }

                    else
                        ((Location) this.arenas[this.nArenas - 1]).updateTimetable(event, date);

                }
            }
        }

    }


}
