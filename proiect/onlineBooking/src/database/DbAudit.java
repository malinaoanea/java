package database;

import java.util.ArrayList;

public class DbAudit {
    DataBaseHelper dataBaseHelper;

    public DbAudit() {
        this.dataBaseHelper = new DataBaseHelper();
    }

    public ArrayList getPeople() {
        return dataBaseHelper.getClients();
    }
}
