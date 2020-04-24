package event;

import location.Arena;
import location.Location;


public class Concert extends Event {
    private Arena[] arena;
    private int n;

    public Concert(String denumire, Arena arena, int index ) {
        super( denumire, index);
        this.arena = new Arena[3];
    }

    public Arena[] getArena() {
        return arena;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :  " + super.toString();
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
