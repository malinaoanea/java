public class Main {
    public static void main(String[] args) {
        DbLocalsEvents dbLocalsEvents = new DbLocalsEvents();
        DbClients dbClients = new DbClients();

        dbLocalsEvents.addEvent("Scorpions", "21 Jan", "Romexpo", "concert");
        dbLocalsEvents.addEvent("Scorpions", "21 Jan", "Malina's Room", "concert");
        dbLocalsEvents.addEvent("Scorpions", "22 Jan", "Beraria H", "concert");
        dbLocalsEvents.addEvent("Fara Zahar", "22 Apr", "Dunno", "concert");
        dbLocalsEvents.addEvent("Bruno Mars", "31 Aug", "Arenele Romane", "concert");
        dbLocalsEvents.addEvent("Desteparea primaverii", "5 Aug", "Teatrul mic", "teatru");
        dbLocalsEvents.addEvent("Ivan cel prost", "15 Aug", "Odeon", "teatru");
        dbLocalsEvents.addEvent("Rocky cel frumos", "5 Apr", "Teatrul mic", "teatru");
        dbLocalsEvents.addEvent("Ocean", "1 Apr", "Multiplex", "movie");
        dbLocalsEvents.addEvent("Mean Girls", "10 Apr", "Cinemacity", "movie");
        dbLocalsEvents.addEvent("Mean Girls", "10 Apr", "Multiplex", "movie");
        dbLocalsEvents.addEvent("Hahaha", "1 Apr", "Multiplex", "movie");

        dbClients.addClient("Ioana", "11");
        dbClients.addClient("Maria", "123");
        dbClients.addSpecialClient("ciuciu", "1");
        dbClients.addSpecialClient("hana", "123");

        Book book = new Book(dbLocalsEvents, dbClients);
        BookingService bookingService = new BookingService(book);
        bookingService.showEvents();
        bookingService.showDatesforEvent("Scorpions");
        bookingService.showLocations();
        bookingService.showEvents();
        bookingService.bookEventLocation("Scorpions", "Romexpo", 1);
        bookingService.clientBuys("haha", "123", "Fara Zahar", "Dunno");
        bookingService.showClients();
        bookingService.showLocationForEvent("Scorpions");
        bookingService.unbookEventLocation("Scorpions", "Romexpo", 1);
        bookingService.showEventsForClient("haha", "123");
        bookingService.bookEventLocation("Ivan cel prost", "Odeon", 1);
        bookingService.showLocationForEvent("Rocky cel frumos");
        bookingService.showLocationForEvent("Bruno Mars");
        bookingService.showLocationForEvent("Mean Girls");
        bookingService.clientBuys("Ioana", "11", "Scorpions", "Romexpo");



    }
}
