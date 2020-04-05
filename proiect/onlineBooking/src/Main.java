public class Main {
    public static void main(String[] args) {
        // CREATES THE THE BD //
        Db db = new Db();
        DBClients dbClients = new DBClients();

        db.addEvent("Scorpions", "21 Jan", "Romexpo", "concert");
        db.addEvent("Scorpions", "21 Jan", "Malina's Room", "concert");
        db.addEvent("Scorpions", "22 Jan", "Beraria H", "concert");
        db.addEvent("Fara Zahar", "22 Apr", "Dunno", "concert");
        db.addEvent("Bruno Mars", "31 Aug", "Arenele Romane", "concert");
        db.addEvent("Desteparea primaverii", "5 Aug", "Teatrul mic", "teatru");
        db.addEvent("Ivan cel prost", "15 Aug", "Odeon", "teatru");
        db.addEvent("Rocky cel frumos", "5 Apr", "Teatrul mic", "teatru");
        db.addEvent("Ocean", "1 Apr", "Multiplex", "movie");
        db.addEvent("Mean Girls", "10 Apr", "Cinemacity", "movie");
        db.addEvent("Mean Girls", "10 Apr", "Multiplex", "movie");
        db.addEvent("Hahaha", "1 Apr", "Multiplex", "movie");

        dbClients.addClient("Ioana", "11");
        dbClients.addClient("Maria", "123");
        dbClients.addSpecialClient("ciuciu", "1");
        dbClients.addSpecialClient("hana", "123");

        Book book = new Book(db, dbClients);
        book.showEvents();
        book.showDatesforEvent("Scorpions");
        book.showLocations();
        book.showEvents();
        book.bookEventLocation("Scorpions", "Romexpo", 1);
        book.clientBuys("haha", "123", "Fara Zahar", "Dunno");
        book.showClients();
        book.showLocationForEvent("Scorpions");
        book.unbookEventLocation("Scorpions", "Romexpo", 1);
        book.showEventsForClient("haha", "123");
        book.bookEventLocation("Ivan cel prost", "Odeon", 1);
        book.showLocationForEvent("Rocky cel frumos");
        book.showLocationForEvent("Bruno Mars");
        book.showLocationForEvent("Mean Girls");



    }
}
