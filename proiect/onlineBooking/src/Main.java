public class Main {
    public static void main(String[] args) {
//        Db db = new Db();
//
//        db.addEvent("florule toamnei", "1 Jan 2019", "Teatrul Mic", "concert");
//        db.addEvent("florule toamnei", "1 Jan 2019", "Teatrul Mic", "concert");

//        Arena arena = new Arena("adresa", "name");
//        if(  ((Location)arena).getName() == "name" )
//            System.out.println("hello");
//        System.out.println( ((Location)arena).getName() );
//
//        Arena arr[];
//        arr = new Arena[3];
//
//        arr[0] = new Arena("adresa1", "name1");
//        arr[0].updateTimetable(new Event("name"), "21 jan");
//        arr[1] = new Arena("adress3", "name2");
//        arr[2] = new Arena("adress3", "name3");
//
//        for(Arena a:arr)
//            System.out.println(a);

//        Event events[];
//        events = new Event[10];
//
//        events[0] = new Concert("Rolling Stones", new Arena("adresa1", "romexpo"));
//        events[1] = new Theatre( "Desteptarea primaverii",new TheatreLoc());
//
//        for(Event e:events)
//            if(e!=null)
//            System.out.println(e.getLocation());

        Db db = new Db();
        db.addEvent("Desteptarea promaverii", "21 Jan 2020", "Teatrul mic", "concert");
        db.addEvent("Rolling Stoned", "40 April 2020", "Romexpo", "concert");
        db.addEvent("Scorpions", "45 May 2021", "Romexpo", "concert");
        db.addEvent("Desteptarea promaverii", "21 Jan 2020", "Teatrul mic", "concert");
        //db.printEvents();
        Book book = new Book(db);
        //book.bookEvent("Desteptarea promaverii");
        //book.showDatesforEvent("Desteptarea promaverii");
        book.bookEventLocation("Desteptarea promaverii", "Teatrul mic", 1);
        book.unbookEventLocation("Desteptarea promaverii", "Teatrul mic", 1);
        book.showLocationForEvent("Scorpions");
    }
}
