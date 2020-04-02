public class Dog extends Animal implements BubbleBathable {

    @Override
    public void  wash() {
        System.out.println("washing a dog");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("dog takes bubble bath");
    }

    @Override
    public void scrub() {
        System.out.println("dog is scrubbing");
    }

    @Override
    public void soak() {
        System.out.println("dog doen t need");
    }
}
