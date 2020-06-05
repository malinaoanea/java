import CSVutils.Singletone;
import client.Person;
import database.Data;
import database.DataBaseHelper;
import event.Concert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Audit {
    private Db db;
    private DbClients dbClients;
    private Book book;
    private BookingService bookingService;
    DataBaseHelper dbHelper;
    private String auditFile = "audit.csv";
    Data data;
    public Audit() {
        this.db = new Db();
        this.dbClients = new DbClients();
        this.book = new Book(db, dbClients);
        this.bookingService = new BookingService(book);
        this.dbHelper = new DataBaseHelper();
        ArrayList<Person> people = dbHelper.getClients();
        this.data = new Data();
        this.data.fetchData();

    }

    private void printMenu() {
        System.out.println("Choose action from below:\n" +
                           "                         1.Add event.\n" +
                           "                         2.Add client.\n" +
                           "                         3.Print dates for an event.\n" +
                           "                         4.Book an event at a specific location.\n" +
                "                         5.Show locations.\n" +
                "                         6.Unbook tickets for an event.\n" +
                "                         7.Show events for a client.\n" +
                "                         8.Show events.\n" +
                "                         9.Show clients.\n" +
                "                         10.Buy a ticket for a new client.\n" +
                "                         11.Show location for an event\n" +
                "                          0.Exit.\n");
    }

    private void updateAuditFile(String actionID ) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


    }

    private int getJob() {
        this.printMenu();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int chooseWhat(String string) {
        if (string == "event") {
            System.out.println("Choose what you want to add:\n" +
                               "                            1.Concert.\n"+
                    "                            2.Theatre\n" +
                    "                            3.Movie.\n");
        }
        else {
            System.out.println("Choose what you want to add:\n" +
                    "                            1.Ordinary client.\n"+
                    "                            2.Special client\n");
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public void doJobs() {
        try {
            boolean stillWorking = true;
            Scanner scanner = new Scanner(System.in);
            while (stillWorking) {
                int jobId = this.getJob();
                if ( jobId == 1 ) {
                    jobId = this.chooseWhat("event");
                    System.out.print("Name of event: "); String name = scanner.nextLine();
                    System.out.print("Location: "); String location = scanner.nextLine();
                    System.out.print("Date: ");String date = scanner.nextLine();
                    if (jobId == 1)
//                        db.addEvent(name, date, location, "concert");
                        data.addEvent(name, date, location, "concert");


                    else if (jobId == 2)
//                        db.addEvent(name, date, location, "theatre");
                        data.addEvent(name, date, location, "theatre");
//                    else db.addEvent(name, date, location, "movie");
                    else data.addEvent(name, date, location, "movie");
//                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//                    String currentThreadName = Thread.currentThread().getName();
//                    Singletone.updateAudit("Added event," + name +',' + location+','+date +','+timeStamp +',' + currentThreadName, auditFile );
                }
                else if ( jobId == 2) {
                    jobId = this.chooseWhat("client");
                    System.out.print("Name: "); String name = scanner.nextLine();
                    System.out.print("CNP: "); String CNP = scanner.nextLine();
                    if (jobId == 1)
//                        dbClients.addClient(name, CNP);
                        data.addClient(name, CNP);
                    else if (jobId == 2)
//                        dbClients.addSpecialClient(name, CNP);
                        data.addClient(name, CNP, 0);
//                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//                    String currentThreadName = Thread.currentThread().getName();
//                    Singletone.updateAudit("Added client," + name +',' + CNP+','+timeStamp +',' + currentThreadName, auditFile );
                }
                else if ( jobId == 0) {
                    stillWorking = false;
                    break;
                }
                else if ( jobId == 3) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
//                    bookingService.showDatesforEvent(name);
                    data.showDatesforEvent(name);
//                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//                    String currentThreadName = Thread.currentThread().getName();
//                    Singletone.updateAudit("Printed events,"+timeStamp+',' + currentThreadName, auditFile );
                }
                else if ( jobId == 4) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    System.out.print("Event location: "); String location = scanner.nextLine();
                    System.out.print("Number of tickets: "); int ti = scanner.nextInt();
//                    bookingService.bookEventLocation(name, location, ti);
                    data.bookEventLocation(name, location, ti);
//                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//                    String currentThreadName = Thread.currentThread().getName();
//                    Singletone.updateAudit("Bought ticket" + name +',' + location+','+ti +','+timeStamp + currentThreadName, auditFile );
                }
                else if ( jobId == 5) {
                    data.showLocations();
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    String currentThreadName = Thread.currentThread().getName();
                    Singletone.updateAudit("Printed locations," +timeStamp +',' + currentThreadName, auditFile );
                }
                else if ( jobId == 6) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    System.out.print("Event location: "); String location = scanner.nextLine();
                    System.out.print("Number of tickets: "); int ti = scanner.nextInt();
                    data.unbookEventLocation(name, location, ti);
//                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//                    String currentThreadName = Thread.currentThread().getName();
//                    Singletone.updateAudit("Unbooked tickets," + name +',' + location+','+ti +','+timeStamp + ',' + currentThreadName, auditFile );
                }
                else if ( jobId == 7) {
                    System.out.print("Client name: "); String name = scanner.nextLine();
                    System.out.print("CNP: "); String cnp = scanner.nextLine();
                    data.showEventsForClient(name, cnp);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    String currentThreadName = Thread.currentThread().getName();
                    Singletone.updateAudit("showed events for client," + name +',' + cnp +','+timeStamp +',' + currentThreadName, auditFile );
                }
                else if ( jobId == 8) {
//                    bookingService.showEvents();
                    data.showEvents();

                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    String currentThreadName = Thread.currentThread().getName();
                    Singletone.updateAudit("Printed events," +timeStamp + ',' + currentThreadName, auditFile );
                }
                else if ( jobId == 10) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    System.out.print("Event location: "); String location = scanner.nextLine();
                    System.out.print("Client name: "); String cname = scanner.nextLine();
                    System.out.print("CNP: "); String cnp = scanner.nextLine();
                    String currentThreadName = Thread.currentThread().getName();
                    data.clientBuys(cname, cnp,name,location);

                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Clients bought specific ticket," + name +',' + location+','+cname +','+timeStamp  + "," + currentThreadName,  auditFile );
                }
                else if ( jobId == 11) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    data.showLocationForEvent(name);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    String currentThreadName = Thread.currentThread().getName();
                    Singletone.updateAudit("Printed location for event," + name  +','+timeStamp + ',' + currentThreadName, auditFile );
                }
                else if ( jobId == 9 ) {
//                    bookingService.showClients();
                    data.showClients();
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    String currentThreadName = Thread.currentThread().getName();
                    Singletone.updateAudit("Printed clients," +timeStamp + ',' + currentThreadName, auditFile );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("All jobs done.");
        }
    }
}
