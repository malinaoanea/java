package location;

import event.Event;

import java.sql.SQLRecoverableException;
import java.sql.Time;
import java.util.Objects;

public class Location {
    private String name;
    private Timetable thisWeekProgramme;


    public Location(String name) {
        this.name = name;
        this.thisWeekProgramme = new Timetable();
    }

    public Timetable getThisWeekProgramme() {
        return thisWeekProgramme;
    }

    public void updateTimetable(Event event, String date) {
        //U HAVE TO UPDATE THE TIME TABLE !!!!!!!!!
        this.thisWeekProgramme.addEvent(event, date);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void printTimeTable() {
        System.out.println("Sceduele for " + this.name + " is: " + thisWeekProgramme.toString());
    }

    public String[] getDatesForEvent( Event event ) {
        int indx = event.getIndxEvent();
        int noOfRepr = event.getNoOfRepr();

        return thisWeekProgramme.getEvent(indx-1, noOfRepr-1);
    }

    public void getEventAt( Event event ) {

        String[] dates = this.getDatesForEvent(event);
        String ans = "At " + name + " dates are: ";

        for(String date:dates) {
            ans = ans + date + " // ";
        }

        System.out.println(ans);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(getName(), location.getName());
    }


}
