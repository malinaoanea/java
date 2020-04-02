import java.util.LinkedList;

public class Queue implements Container {
    private LinkedList<Task> tasks;
    private int no;

    @Override
    public void add(Task t) {
        no++;
        tasks.add(t);
    }

    @Override
    public Task pop() {
        tasks.getFirst().doSomething();
        no--;
        return tasks.removeFirst();
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean isEmpty() {
        if(no==0) return true;
        else return false;
    }

    public Queue(LinkedList<Task> tasks, int no) {
        this.tasks = tasks;
        this.no = no;
    }
}
