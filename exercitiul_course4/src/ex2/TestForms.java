package ex2;

public class TestForms {
    public static void main(String[] args) {
        Form forms[] = { new Circle("red", (float) 3.12), new Triangle("blue", (float) 2,12) };
        for(Form i:forms) {
            System.out.println(i);
            if ( i instanceof Circle ) {
                ((Circle) i).printCircleDimentions();
            }
            else {
                ((Triangle) i).printTriangleDimensions();
            }
        }
    }
}
