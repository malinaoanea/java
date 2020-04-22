public class Book {
    DbLocalsEvents dbLocalsEvents;
    DbClients dbClients;

    public void setDbClients(DbClients dbClients) {
        this.dbClients = dbClients;
    }

    public void setDbLocalsEvents(DbLocalsEvents dbLocalsEvents) {
        this.dbLocalsEvents = dbLocalsEvents;
    }

    public DbClients getDbClients() {
        return dbClients;
    }

    public DbLocalsEvents getDbLocalsEvents() {
        return dbLocalsEvents;
    }

    public Book(DbLocalsEvents dbLocalsEvents, DbClients db2) {
        this.dbLocalsEvents = dbLocalsEvents;
        this.dbClients = db2;
    }




}
