package candy;

import java.util.Objects;

public class Lindt extends CandyBox {
    private float height, width, length;

    public Lindt() {
        this.height = this.length = this.width = 0;
    }

    public Lindt(float height, float with, float length) {
        super("Lindt", "Switzerland");
        this.height = height;
        this.length = length;
        this.width = with;
    }

    public float getVolume() {
        return this.height * this.width * this.length;
    }


    public String toString() {
        return super.toString() + " has volume " + String.valueOf( this.getVolume() );
    }

    public void printLindtDim() {
        System.out.println(this.height + this.height + this.width);
    }
}
