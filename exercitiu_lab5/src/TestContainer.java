import java.util.LinkedList;

public class TestContainer {
    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<Task>();

        tasks.add(new OutTask("hei"));
        tasks.add(new RandomOutTask());
        tasks.add(new RandomOutTask());
        tasks.add(new CounterOutTask());

//        Stack stack = new Stack(tasks, 4);
//
//        RandomOutTask newOne  = new RandomOutTask();
//        OutTask outTask = new OutTask("heihei");
//        stack.add(newOne);
//        stack.add(outTask);
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();

        Queue queue = new Queue(tasks, 4);
        OutTask outTask1 = new OutTask("heihei1");
        queue.add(outTask1);
        queue.pop();
        queue.pop();

    }
}
