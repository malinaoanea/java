public class Main {
    public static void main(String[] args) {
//        Db db = new Db();
//        DbClients dbClients = new DbClients();

////        dbLocalsEvents.addEvent("Scorpions", "21 Jan", "Romexpo", "concert");
////        dbLocalsEvents.addEvent("Scorpions", "21 Jan", "Malina's Room", "concert");
////        dbLocalsEvents.addEvent("Scorpions", "22 Jan", "Beraria H", "concert");
////        dbLocalsEvents.addEvent("Fara Zahar", "22 Apr", "Dunno", "concert");
////        dbLocalsEvents.addEvent("Bruno Mars", "31 Aug", "Arenele Romane", "concert");
//////        dbLocalsEvents.addEvent("Desteparea primaverii", "5 Aug", "Teatrul mic", "teatru");
//////        dbLocalsEvents.addEvent("Ivan cel prost", "15 Aug", "Odeon", "teatru");
////        dbLocalsEvents.addEvent("Rocky cel frumos", "5 Apr", "Teatrul mic", "teatru");
//////        dbLocalsEvents.addEvent("Ocean", "1 Apr", "Multiplex", "movie");
////        dbLocalsEvents.addEvent("Mean Girls", "10 Apr", "Cinemacity", "movie");
//////        dbLocalsEvents.addEvent("Mean Girls", "10 Apr", "Multiplex", "movie");
//////        dbLocalsEvents.addEvent("Hahaha", "1 Apr", "Multiplex", "movie");
////
////        dbClients.addClient("Ioana", "11");
////        dbClients.addClient("Maria", "123");
////        dbClients.addSpecialClient("ciuciu", "1");
////        dbClients.addSpecialClient("Maria", "1");
//
////        dbClients.addSpecialClient("hana", "123");
////
//        Book book = new Book(db, dbClients);
//        BookingService bookingService = new BookingService(book);
        Audit audit = new Audit();
        audit.doJobs();


    }
}
