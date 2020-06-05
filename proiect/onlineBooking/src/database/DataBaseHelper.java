package database;

import CSVutils.Singletone;
import client.Client;
import client.Person;
import client.ProClient;
import event.Concert;
import event.Event;
import event.Movie;
import event.Theatre;
import location.Arena;
import location.Cinema;
import location.Location;
import location.TheatreLoc;
import services.LocationServices;

import javax.swing.text.html.HTMLEditorKit;
import java.net.Inet4Address;
import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class DataBaseHelper {
    Connection conn = null;
    private String url;
    ArrayList<Person> clients;
    PreparedStatement ps;

    public DataBaseHelper(){
        url = "jdbc:sqlite:db8.db";
        clients = new ArrayList<Person>();

        this.connectToDataBase();
//        delete_all_tables();
        this.prepare_clients_table();
        this.prepare_events_table();
        this.prepare_locations_table();
        this.prepare_timetable_table();
        this.prepare_clients_and_events();
    }

    void delete_all_tables() {
        String del_clients = "DROP TABLE IF EXISTS 'myDatabase.clients' ";
        String del_events = "DROP TABLE IF EXISTS 'myDatabase.event' ";
        String del_locations = "DROP TABLE IF EXISTS 'myDatabase.locations' ";
        String del_timetable = "DROP TABLE IF EXISTS 'myDatabase.timetable' ";

        String[] arr = {del_clients, del_events, del_locations, del_timetable};

        for(String del:arr) {
            try {
                Statement stmt = this.conn.createStatement();
                stmt.execute(del);
                System.out.println("done: " + del);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
        }

    }

    void connectToDataBase() {

        try {
            Class.forName("org.sqlite.JDBC");
            // creates a new db if it doesn't exist
            conn = DriverManager.getConnection(this.url);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully.");
    }

    void prepare_clients_table() {
        // opens the client table and events table and location table
        // if they don't exist, it creates new ones

        // SQL statement for creating a new table

        String sql = "CREATE TABLE IF NOT EXISTS clients (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                + " name text NOT NULL ,\n"
                + " cnp text,\n"
                + " proclient text,\n"
                + " events text\n"
                + ");";

        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
            System.out.println("All good with clients table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    void prepare_clients_and_events() {
        // opens the client table and events table and location table
        // if they don't exist, it creates new ones

        // SQL statement for creating a new table

        String sql = "CREATE TABLE IF NOT EXISTS clients_and_events (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                + " event_id text NOT NULL ,\n"
                + " client_id text,\n"
                + " n_tickets text\n"
                + ");";

        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
            System.out.println("All good with clients table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    void prepare_events_table() {
        // opens the client table and events table and location table
        // if they don't exist, it creates new ones

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS events (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	type text NOT NULL,\n"
                +"	date text NOT NULL,\n"
                + " location text"
                + ");";

        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
            System.out.println("All good with events table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    void prepare_locations_table() {
        // opens the client table and events table and location table
        // if they don't exist, it creates new ones

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS locations (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	type text NOT NULL,\n"
                + " nmax\n"
                + ");";

        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
            System.out.println("All good with locations table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    void prepare_timetable_table() {
        // opens the client table and events table and location table
        // if they don't exist, it creates new ones

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS timetable (\n"
                + "	event_id integer PRIMARY KEY,\n"
                + "	location_name text NOT NULL,\n"
                + "	date text NOT NULL\n"
                + ");";

        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
            System.out.println("All good with timetable table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public void addLocation(String name, String type, int nmax_tickets)  {
        // adds a new location to database if doesn't exist
        String query = "SELECT count(*)  FROM locations WHERE name like '" + name +"'";
        try {
            ps = conn.prepareStatement(query);
        } catch (Exception e) {
            System.out.print("\nUnable to search for "+ name + "..\n" + e + "\n");
        }

        try (ResultSet rs = ps.executeQuery()) {
            // Only expecting a single result
            if (rs.next()) {
                boolean found = rs.getBoolean(1); // "found" column
                System.out.println("found=" + found);
                if (found) {
                    try {

                        ps = conn.prepareStatement("insert into locations( name, type, nmax) values(?,?,?)");


                        ps.setString(1, name);

                        ps.setString(2, type);

                        ps.setString(3, String.valueOf(nmax_tickets));

                        ps.executeUpdate();

                        System.out.println("1 Record inserted...");

                    } catch(Exception e) {

                        System.out.print("\nUnable to insert..\n" + e + "\n");

                    }
                } else {
                    System.out.println( name +  " already in database.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Person checkForClient(ArrayList<Person> people, String CNP) {
        for (Person person:people) {
            if (person.getCNP().equals(CNP))
                return person;

        }
        return null;
    }

    public void addClient(String name, String cnp) {
        try {

            ps = conn.prepareStatement("insert into clients( name, cnp, proclient, events) values(?,?,?,?)");


            ps.setString(1, name);

            ps.setString(2, cnp);

            ps.setString(3, "-1");

            ps.setString(4, "none");


            ps.executeUpdate();

            System.out.println("1 Record inserted...");

        } catch(Exception e) {

            System.out.print("\nUnable to insert..\n" + e + "\n");

        }
    }

    // adds a special client to the db
    // third parameter is the number of tickets he bouht til now
    public void addClient(String name, String cnp, int no_of_tickets) {
        try {

            ps = conn.prepareStatement("insert into clients( name, cnp, proclient, events) values(?,?,?,?)");


            ps.setString(1, name);

            ps.setString(2, cnp);

            ps.setString(3, String.valueOf(no_of_tickets));

            ps.setString(4, "none");


            ps.executeUpdate();

            System.out.println("1 Record inserted...");

        } catch(Exception e) {

            System.out.print("\nUnable to insert..\n" + e + "\n");

        }
    }

    public ArrayList<Person> getClients() {

        String getClients = "SELECT name, id, proclient, events, cnp FROM clients";

        try (Statement stmt = conn.createStatement()) {

            ArrayList<Person> people = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getClients);

            while (result.next()) {
                String proclient_n = result.getString("proclient");
                if (proclient_n == "-1") {
                    Client client = new Client(result.getString("name"), result.getString("cnp"), result.getString("id"));
                    people.add(client);
                }
                else {
                    ProClient proClient = new ProClient(result.getString("name"), result.getString("cnp"), result.getString("id"));
                    people.add(proClient);
                }

            }
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Location> getLocations() {

        String getClients = "SELECT name, type, nmax FROM locations";

        try (Statement stmt = conn.createStatement()) {

            ArrayList<Location> locations = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getClients);

            while (result.next()) {
                String type = result.getString("type");
                if (type == "arena") {
                    Arena arena = new Arena(result.getString("name"));
                    locations.add(arena);
                }
                else if (type == "theatre"){
                    TheatreLoc theatreLoc = new TheatreLoc(result.getString("name"), Integer.parseInt(result.getString("nmax")));
                    locations.add(theatreLoc);
                } else  {
                    Cinema cinema = new Cinema(result.getString("name"), Integer.parseInt(result.getString("nmax")));
                    locations.add(cinema);
                }

            }
            return locations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person getClientWitID(ArrayList<Person>people, String id) {
        System.out.println("to be searched" + id + "\n");
        for (Person person:people) {
            System.out.println(person.getId() + " ");
            if (person.getId().equals(id) )
                return person;
        }
        return null;
    }

    public Event getEventsWitID(ArrayList<Event>events, String id) {
        for (Event event:events) {
            if (event.getId().equals(id))
                return event;
        }
        return null;
    }

    public void getevents_with_people(ArrayList<Person> people, ArrayList<Event> events) {

        String getClients = "SELECT client_id, event_id, n_tickets FROM clients_and_events";

        try (Statement stmt = conn.createStatement()) {

            ResultSet result = stmt.executeQuery(getClients);

            while (result.next()) {
                String client_id = result.getString("client_id");
                String event_id = result.getString("event_id");
                int n_tickets = Integer.valueOf(result.getString("n_tickets"));
                System.out.println(client_id + ": " + this.getEventsWitID(events, event_id));
                this.getClientWitID(people, client_id).addEvent( this.getEventsWitID(events, event_id) );
                }

            } catch (SQLException ex) {
            ex.printStackTrace();
            }


    }

    public void addEvent(String name,String date,String location, String type) {
        try {

            ps = conn.prepareStatement("insert into events( name, type, date, location) values(?,?,?,?)");


            ps.setString(1, name);

            ps.setString(2, type);

            ps.setString(3, date);

            ps.setString(4, location);


            ps.executeUpdate();

            System.out.println("1 Record inserted...");

        } catch(Exception e) {

            System.out.print("\nUnable to insert..\n" + e + "\n");

        }
    }

    public void addEvent_Client(String client_id,String event_id, int ntickets) {
        try {

            ps = conn.prepareStatement("insert into clients_and_events ( client_id, event_id, n_tickets) values(?,?,?)");


            ps.setString(1, client_id);

            ps.setString(2, event_id);

            ps.setString(3, String.valueOf(ntickets));


            ps.executeUpdate();

            System.out.println("1 Record inserted into clients_and_events...");

        } catch(Exception e) {

            System.out.print("\nUnable to insert..\n" + e + "\n");

        }
    }

    public Event checkForEvent(ArrayList<Event> events, String name) {
        for (Event event:events) {
            System.out.println(event.getName() + ",");

            if (event.getName().equals(name))
                return event;
        }

            return null;
    }

    public Location checkForLocation(ArrayList<Location> locations, String name) {
        for (Location location:locations)
            if (location.getName() == name)
                return location;

            return null;
    }

    public ArrayList<Event> getEvents(ArrayList <Location> locations) {
        String getEvents = "SELECT name, type, date, location, id FROM events";


        ArrayList<Event> events = new ArrayList();

        try (Statement stmt = conn.createStatement()) {

            ResultSet result = stmt.executeQuery(getEvents);

            while (result.next()) {
                String name = result.getString("name");
                String date = result.getString("date");
                String location  = result.getString("location");
                String id = result.getString("id");
                String type = result.getString("type");

                if (type.equals("concert") )
                    this.addConcert(name, date, location, locations, events, id);

                else if (type.equals("theatre"))
                    this.addTheatre(name, date, location, locations, events, id);
                else  this.addMovie(name, date, location, locations, events, id);
            }
            return events;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addTheatre(String name, String date, String locationName, ArrayList<Location> locations, ArrayList<Event> events, String id) {
        TheatreLoc l = (TheatreLoc) this.checkForLocation(locations, locationName);
        if(l==null) {
            TheatreLoc theatreLoc = new TheatreLoc(locationName, 5);
            locations.add(theatreLoc);
            l = theatreLoc;
        }

        Theatre t = (Theatre)this.checkForEvent(events,name);
        if(t == null) {
            Theatre theatre = new Theatre(name, l, id);
            events.add(theatre);
            t = theatre;
        }

        LocationServices locationServices = new LocationServices(l);
        locationServices.updateTimetable(t, date);
        t.addTheatreLoc(l);

    }

    public void addMovie(String name, String date, String locationName, ArrayList<Location> locations, ArrayList<Event> events, String id) {
        Cinema l = (Cinema) this.checkForLocation(locations, locationName);
        if(l==null) {
            Cinema cinema = new Cinema(locationName, 5);
            locations.add(cinema);
            l = cinema;
        }

        Movie t = (Movie) this.checkForEvent(events, name);
        if(t == null) {
            Movie movie = new Movie(name, l, id);
            events.add(movie);
            t = movie;
        }

        LocationServices locationServices = new LocationServices(l);
        locationServices.updateTimetable(t, date);

        t.addCinema(l);
    }

    public void addConcert(String name, String date, String locationName, ArrayList<Location> locations, ArrayList<Event> events, String id) {
        // Bug to fix : cand adauga un eveniment nou, daca mai exista o data face o copie
        Arena l = (Arena)this.checkForLocation(locations, locationName);
        if(l == null) {
            Arena arena = new Arena(locationName);
            locations.add( arena );
            l = arena;
        }

        Concert c = (Concert)this.checkForEvent(events, name);
        if(c == null) {
            Concert concert = new Concert(name,l, id, date );
            events.add( concert );
            c = concert;
        }
        LocationServices locationServices = new LocationServices(l);
        locationServices.updateTimetable(c, date);
        c.addArena(l);

    }

    public void delete(String id, String table) {
        String sql = "DELETE FROM " + table + " WHERE id = " + id;
        try {
             ps = conn.prepareStatement(sql);

//            // set the corresponding param
//            ps.setInt(1, id);
//            // execute the delete statement
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateName(String id, String table_name, String newName) {
        String sql = "UPDATE " + table_name + " SET name = " + newName
                + "WHERE id = " + id;
        try {
            ps = conn.prepareStatement(sql);

//            // set the corresponding param
//            ps.setInt(1, id);
//            // execute the delete statement
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
