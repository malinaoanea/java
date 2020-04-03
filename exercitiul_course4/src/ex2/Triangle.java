package ex2;

import java.util.Objects;

public class Triangle extends Form {
    private float height, base;

    public Triangle() {
    }

    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    float getArea() {
        float v = base * height / 2;
        return v;
    }

    @Override
    public String toString() {
        return "Triunghi: " + super.toString() +" " + getArea() +" ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.height, height) == 0 &&
                Float.compare(triangle.base, base) == 0;
    }

    public void printTriangleDimensions() {
        System.out.println("base = " + base +  ", heights " + height );
    }

}
