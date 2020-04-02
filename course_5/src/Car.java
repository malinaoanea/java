public class Car implements BubbleBathable{
    public void  wash() {
        System.out.println("washing a car");
    }
    public void soak() {
        System.out.println("soaking the car");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("takes bubblebath");
    }

    @Override
    public void scrub() {
        System.out.println("car is scrubbing");
    }
}
