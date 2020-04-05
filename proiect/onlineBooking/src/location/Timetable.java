package location;

import event.Event;

import java.util.*;

public class Timetable {
    //timetable[i] = all dates when show with index i is available even if fully booked
    //it handles maximum 10 shows each with max 10 apparances
    private String[][] timetable;
    int noOfEvents;

    public Timetable() {
        this.timetable = new String[10][10];
        this.noOfEvents = 0;
    }

    public void modifyTimetable(int ind,int nrep, String date) {
        this.timetable[ind][nrep] = date;
    }

    public String[][] getTimetable() {
        return this.timetable;
    }

    public void addEvent(Event event, String date) {
        String str = event.toString() + " nrepr=" + event.getNoOfRepr() + "  indx=" + event.getIndxEvent();
//        this.timetable[0][0] = "a";
//        this.timetable[event.getIndxEvent() - 1][event.getNoOfRepr()-1] = date;
        this.modifyTimetable(event.getIndxEvent() - 1, event.getNoOfRepr() -1, date);
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
