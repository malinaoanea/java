public class CounterOutTask implements Task {
    public static int counter = 0;

    @Override
    public void doSomething() {
        counter++;
        System.out.println(counter);
    }

}
