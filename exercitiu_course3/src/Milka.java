package candy;

public class Milka extends CandyBox {
    private float r, height;

    public Milka() {
        this.height = this.r = 0;
    }

    public Milka(float r, float height) {
        super("Milka", "Switzerland");
        this.r = r;
        this.height = height;
    }

    public float getVolume() {
        return (float) (3.14 * this.height * this.r * this.r);
    }

    public String toString() {
        return super.toString() + " has volume " + String.valueOf( this.getVolume() );
    }

    public void PrintMilkaDim() {
        System.out.println( this.height +  this.r );
    }
}
