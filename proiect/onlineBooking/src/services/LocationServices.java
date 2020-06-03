package services;

import event.Event;
import location.Location;

public class LocationServices {
    Location location;

    public LocationServices(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String[] getDatesForEvent( Event event ) {
        int indx = Integer.valueOf(event.getId());
        int noOfRepr = event.getNoOfRepr();

        return this.location.getThisWeekProgramme().getEvent(indx-1, noOfRepr-1);
    }

    public void getEventAt( Event event ) {

        String[] dates = this.getDatesForEvent(event);
        String ans = "At " + location.getName() + " dates are: ";

        for(String date:dates) {
            if(date != null)
                ans = ans + date + " // ";
        }

        System.out.println(ans);
    }

    public void updateTimetable(Event event, String date) {
        //U HAVE TO UPDATE THE TIME TABLE !!!!!!!!!
        this.location.getThisWeekProgramme().addEvent(event, date);
    }
}
