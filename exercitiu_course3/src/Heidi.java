package candy;

public class Heidi extends CandyBox {
    private float dimension;

    public Heidi() {
        super("Heidi", "Germany");
        this.dimension = 0;
    }

    public  Heidi(float dimension) {
        super("Heidi", "Germany");
        this.dimension = dimension;
    }

    public float getVolume() {
        return this.dimension * this.dimension * this.dimension;
    }

    public String toString() {
        return super.toString() + " has volume " + String.valueOf( this.getVolume() );
    }

    public void printHeidiDim() {
        System.out.println(this.dimension);
    }
}
