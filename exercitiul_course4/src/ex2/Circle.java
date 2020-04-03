package ex2;

public class Circle extends Form {
    float radius;

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    public Circle() {
    }

    @Override
    float getArea() {
        float v = (float) (3.14 * radius * radius);
        return v;
    }

    @Override
    public String toString() {
        return "Cerc: " + super.toString() + " " + getArea() +" ";
    }

    public void printCircleDimentions() {
        System.out.println("radius: " + radius);
    }
}
