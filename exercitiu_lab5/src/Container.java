public interface Container {
    void add(Task t);
    Task pop();
    void remove();
    boolean isEmpty();
}
