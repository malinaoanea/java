package location;

public class Cinema extends Location {
    private int maxCapacity;
    private int ticketsBooked;

    public Cinema(String name, int n) {
        super(name);
        maxCapacity = n;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }

    public boolean book(int n) {
        if(this.ticketsBooked + n <= maxCapacity) {
            ticketsBooked += n;
            return true;
        }
        System.out.println("There are not enough tickets for " + super.toString() );
        return false;
    }

    public boolean unbook(int n) {
        if(this.ticketsBooked - n > 0) {
            ticketsBooked -= n;
            return true;
        }

        System.out.println("Not enough tickets available for unbooking for " + super.toString() );
        return false;
    }
}
