package location;

public class TheatreLoc extends Location {
    public TheatreLoc() {
        super("na");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }
}
