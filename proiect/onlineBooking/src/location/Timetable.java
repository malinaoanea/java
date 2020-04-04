package location;

import event.Event;

import java.util.*;

public class Timetable {
    //timetable[i] = all dates when show with index i is available even if fully booked
    //it handles maximmum 10 shows each with max 10 apparances
    private String[][] timetable;
    int noOfEvents;

    public Timetable( int noOfEvents) {
        this.timetable = new String[10][10];
        this.noOfEvents = noOfEvents;
    }

    public void addEvent(Event event, String date) {
        timetable[event.getIndxEvent()][event.getNoOfRepr()] = date;
        event.getNoOfRepr();

    }
}
