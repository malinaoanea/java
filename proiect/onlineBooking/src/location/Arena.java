package location;

import java.util.Arrays;
import java.util.Objects;

public class Arena extends Location {
    private ArenaSection[] arenaSections;
    int maxCapacity;
    int currArenaIndex;

    public Arena( String name) {
        super(name);
        this.maxCapacity = 5;
        this.arenaSections = new ArenaSection[maxCapacity];
        this.arenaSections[0] = new ArenaSection("1", 5, 0);
        this.currArenaIndex = 1;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public ArenaSection addSection(){
        currArenaIndex += 1;
        if( currArenaIndex > maxCapacity ) {
            System.out.println("Too many areas");
            return arenaSections[maxCapacity-1];
        }

        String name = String.valueOf(currArenaIndex);
        arenaSections[currArenaIndex-1] = new ArenaSection(name, 5,0 );
        return arenaSections[currArenaIndex-1];
    }

    public boolean book(int n) {

        //TO DO: BOOK FOR ONE SPECIFIC AREA
        for( ArenaSection a: arenaSections )
            if (a.chekForTickets(n) == true) {
                a.book(n);
                return true;
            }


        if ( currArenaIndex == maxCapacity ) {
            //arena is full
            return false;
        }

        else {
            this.addSection().book(n);
            return true;
        }

    }

    public void setArenaSections(ArenaSection[] arenaSections) {
        this.arenaSections = arenaSections;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setCurrArenaIndex(int currArenaIndex) {
        this.currArenaIndex = currArenaIndex;
    }

    public ArenaSection[] getArenaSections() {
        return arenaSections;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrArenaIndex() {
        return currArenaIndex;
    }

    public boolean unbook(int n) {

        for( ArenaSection a: arenaSections )
            if (a.chekForTicketsToUnbook(n)){
                a.unbook(n);
                return true;
            }
        return false;

    }


    @Override
    public String toString() {
        return super.toString() + "(" +  this.getClass().getSimpleName() + ")";
    }

}
