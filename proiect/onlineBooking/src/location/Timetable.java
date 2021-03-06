package location;

import event.Event;

import java.util.*;

public class Timetable {
    //timetable[i] = all dates when show with index i is available even if fully booked
    //it handles maximum 10 shows each with max 10 apparances
    private String[][] timetable;
    int noOfEvents;

    public Timetable() {
        this.timetable = new String[100][100];
        this.noOfEvents = 0;
    }

    public void modifyTimetable(int ind,int nrep, String date) {
        System.out.println(ind + " " + nrep);
        this.timetable[ind][nrep] = date;
    }

    public void setNoOfEvents(int noOfEvents) {
        this.noOfEvents = noOfEvents;
    }

    public void setTimetable(String[][] timetable) {
        this.timetable = timetable;
    }

    public int getNoOfEvents() {
        return noOfEvents;
    }

    public String[][] getTimetable() {
        return this.timetable;
    }

    public void addEvent(Event event, String date) {
        this.modifyTimetable(Integer.valueOf(event.getId()) - 1, event.getNoOfRepr() -1, date);
        event.addRepr();
    }

    @Override
    public String toString() {
        String str ="";
        for(int i = 0; i < 10; i++) {
                boolean ok = false;
                for (int j = 0; j < 10; j++) {
                    if (timetable[i][j] != null) {
                        str = str + timetable[i][j] + " ";
                        ok = true;
                    }
                }
                if(ok == true)
                    str += '\n';
            }
        if ( str=="" ) {
            str = "Timetable is empty";
        }

        return str;
    }

    public String[] getEvent(int indx, int nRep) {
        //we surely know that the event takes place here

        String[] ans;
        ans = new String[nRep];

        for(int i = 0; i < nRep; i++) {
            ans[i] = this.timetable[indx][i];
        }
        return ans;
    }
}
