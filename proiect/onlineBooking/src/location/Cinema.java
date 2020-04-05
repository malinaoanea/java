package location;

public class Cinema extends Location {


    public Cinema(String name, String adress) {
        super(name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }
}
