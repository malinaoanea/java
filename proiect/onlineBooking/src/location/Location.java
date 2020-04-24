package location;

import java.util.Objects;

public class Location {
    private String name;
    private Timetable thisWeekProgramme;

    public void setName(String name) {
        this.name = name;
    }

    public void setThisWeekProgramme(Timetable thisWeekProgramme) {
        this.thisWeekProgramme = thisWeekProgramme;
    }

    public Location(String name) {
        this.name = name;
        this.thisWeekProgramme = new Timetable();
    }

    public Timetable getThisWeekProgramme() {
        return thisWeekProgramme;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(getName(), location.getName());
    }


    public void saveData(String fileName) {
    }
}
