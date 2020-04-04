package event;

public class Event {
    private int indxEvent;
    private int noOfRepr;

    public Event(int indxEvent, int noOfRepr) {
        this.indxEvent = indxEvent;
        this.noOfRepr = noOfRepr;
    }

    public int getIndxEvent() {
        return indxEvent;
    }

    public int getNoOfRepr() {
        return noOfRepr;
    }

    public void addRepr() {
        noOfRepr += 1;
    }
}
