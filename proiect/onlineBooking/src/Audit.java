import CSVutils.Singletone;
import client.Client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Audit {
    private Db db;
    private DbClients dbClients;
    private Book book;
    private BookingService bookingService;
    private String auditFile = "audit.csv";
    public Audit() {
        db = new Db();
        dbClients = new DbClients();
        book = new Book(db, dbClients);
        bookingService = new BookingService(book);
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
                        db.addEvent(name, date, location, "concert");
                    else if (jobId == 2)
                        db.addEvent(name, date, location, "theatre");
                    else db.addEvent(name, date, location, "movie");
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Added event," + name +',' + location+','+date +','+timeStamp, auditFile );
                }
                else if ( jobId == 2) {
                    jobId = this.chooseWhat("client");
                    System.out.print("Name: "); String name = scanner.nextLine();
                    System.out.print("CNP: "); String CNP = scanner.nextLine();
                    if (jobId == 1)
                        dbClients.addClient(name, CNP);
                    else if (jobId == 2)
                        dbClients.addSpecialClient(name, CNP);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Added client," + name +',' + CNP+','+timeStamp, auditFile );
                }
                else if ( jobId == 0) {
                    stillWorking = false;
                    break;
                }
                else if ( jobId == 3) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    bookingService.showDatesforEvent(name);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Printed events,"+timeStamp, auditFile );
                }
                else if ( jobId == 4) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    System.out.print("Event location: "); String location = scanner.nextLine();
                    System.out.print("Number of tickets: "); int ti = scanner.nextInt();
                    bookingService.bookEventLocation(name, location, ti);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Bought ticket" + name +',' + location+','+ti +','+timeStamp, auditFile );
                }
                else if ( jobId == 5) {
                    bookingService.showLocations();
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Printed locations," +timeStamp, auditFile );
                }
                else if ( jobId == 6) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    System.out.print("Event location: "); String location = scanner.nextLine();
                    System.out.print("Number of tickets: "); int ti = scanner.nextInt();
                    bookingService.unbookEventLocation(name, location, ti);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Unbooked tickets," + name +',' + location+','+ti +','+timeStamp, auditFile );
                }
                else if ( jobId == 7) {
                    System.out.print("Client name: "); String name = scanner.nextLine();
                    System.out.print("CNP: "); String cnp = scanner.nextLine();
                    bookingService.showEventsForClient(name, cnp);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("showed events for client," + name +',' + cnp +','+timeStamp, auditFile );
                }
                else if ( jobId == 8) {
                    bookingService.showEvents();

                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Printed events," +timeStamp, auditFile );
                }
                else if ( jobId == 10) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    System.out.print("Event location: "); String location = scanner.nextLine();
                    System.out.print("Client name: "); String cname = scanner.nextLine();
                    System.out.print("CNP: "); String cnp = scanner.nextLine();
                    bookingService.clientBuys(cname, cnp,name,location);

                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Clients bought specific ticket," + name +',' + location+','+cname +','+timeStamp, auditFile );
                }
                else if ( jobId == 11) {
                    System.out.print("Event name: "); String name = scanner.nextLine();
                    bookingService.showLocationForEvent(name);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Printed location for event," + name  +','+timeStamp, auditFile );
                }
                else if ( jobId == 9 ) {
                    bookingService.showClients();
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    Singletone.updateAudit("Printed clients," +timeStamp, auditFile );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("All jobs done.");
        }
    }
}
