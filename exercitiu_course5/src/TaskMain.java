public class TaskMain {
    public static void main(String[] args) {
        Task outTask = new OutTask("hello");

        Task randomOutTask = new RandomOutTask();

        Task counterOutTask = new CounterOutTask();

        randomOutTask.doSomething();
        counterOutTask.doSomething();
        counterOutTask.doSomething();
        outTask.doSomething();
        randomOutTask.doSomething();
        outTask.doSomething();
    }
}
