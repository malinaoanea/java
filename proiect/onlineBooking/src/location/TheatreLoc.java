package location;

public class TheatreLoc extends Location {
    private int nTickets;
    private int bookedTickets;
    private int unbookedTickets;


    public TheatreLoc(String name, int nTickets) {
        super(name);
        this.nTickets = nTickets;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }

    public boolean book(int n) {
        if(bookedTickets + n <= nTickets) {
            bookedTickets += n;
            unbookedTickets -= n;
            return  true;
        }
        System.out.println("There are not enough tickets for " + super.toString() );
        return false;
    }

    public boolean unbook(int n) {
        if(bookedTickets >= n) {
            bookedTickets -= n;
            unbookedTickets += n;
            return true;
        }
        System.out.println("Not enough tickets available for unbooking for " + super.toString() );
        return false;
    }

}
