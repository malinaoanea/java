public class Book {
    Db db;
    DbClients dbClients;

    public void setDbClients(DbClients dbClients) {
        this.dbClients = dbClients;
    }

    public void setDb(Db db) {
        this.db = db;
    }

    public DbClients getDbClients() {
        return dbClients;
    }

    public Db getDb() {
        return db;
    }

    public Book(Db db, DbClients db2) {
        this.db = db;
        this.dbClients = db2;
    }




}
