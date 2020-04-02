public class Cup implements BubbleBathable {
    double vloume;
    String color;

    public int getLevelOfFragillity() {
        return Washable.fragile;
    }

    @Override
    public  boolean needsWashing() {
        return false;
    }

    @Override
    public void  wash() {
        needsWashing();
        System.out.println("washing a cup");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("Doesn't neeed bubble bath");
    }

    @Override
    public void scrub() {
        System.out.println("cup need soft scrubbing");

    }

    @Override
    public void soak() {

    }
}
