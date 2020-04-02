import java.util.Random;

public class RandomOutTask implements Task {
    private int number;

    public RandomOutTask() {
        Random rand = new Random();
        this.number = rand.nextInt();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void doSomething() {
        System.out.println(this.getNumber());
    }
}
