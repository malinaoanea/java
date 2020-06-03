package event;

import location.Arena;
import location.Location;


public class Concert extends Event {
    private Arena[] arena;
    private int n;
    private String date;

    public String getDate() {
        return date;
    }

    public Concert(String denumire, Arena arena, String index ) {
        super( denumire, index);
        this.arena = new Arena[3];
    }

    public Concert(String denumire, Arena arena, String index, String date ) {
        super( denumire, index);
        this.arena = new Arena[3];
        this.date = date;
    }



    public Arena[] getArena() {
        return arena;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return super.toString() + "(" +  this.getClass().getSimpleName() + ")";
    }

    @Override
    public Location[] getLocation() {
        return arena;
    }

    public void addArena(Arena a) {
        if (n < 3) this.arena[n++] = a;
        else System.out.println("Too many arenas for " + super.toString());
    }

    @Override
    protected String getType() {
        return  "concert";
    }

    @Override
    protected String toCSV() {
        String string = super.toCSV();
        return  string;
    }
}
