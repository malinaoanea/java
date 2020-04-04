package location;

import java.sql.Time;

public class Location {
    private String name;
    private String adress;
    private Timetable thisWeekProgramme;

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public Location(String adress) {
        this.adress = adress;
    }
}
