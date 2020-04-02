import java.util.LinkedList;

public class Stack implements Container {
    private LinkedList<Task> tasks;
    private int no = 0;

    public Stack(LinkedList<Task> tasks, int no) {
        this.tasks = tasks;
        this.no = no;
    }

    @Override
    public void add(Task t) {
        no++;
        tasks.add(t);

    }

    @Override
    public Task pop() {
        System.out.println("no=" + no);
        if(no == 0)
            throw new RuntimeException("too many pops");
        no--;
        tasks.getLast().doSomething();
        return tasks.removeLast();
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean isEmpty() {
        if(no == 0)
            return true;
        else return false;
    }
}
