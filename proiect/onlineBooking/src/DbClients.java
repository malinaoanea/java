import CSVutils.Singletone;
import client.Client;
import client.Person;
import client.ProClient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DbClients {
    ArrayList<Person> clients;
    private static String ClientsFileName = "ordinaryClients.csv";
    private static String ProClientsFileName = "proClients.csv";
    private static String PeopleFileName = "people.csv";

    public DbClients() {
        clients = new ArrayList<Person>();
        // gets all the data from the csv files
        Singletone.getData(ClientsFileName, ClientsFileName, ProClientsFileName, clients);
        Singletone.getData(ProClientsFileName,ClientsFileName, ProClientsFileName, clients);
    }

    public void addClient(String name, String CNP) {
        // Adds new ordinary client to csv for ordinary clients and to csv for arr clients.
        Client client = new Client(name, CNP);
        if (clients.contains(client)) {
            System.out.println(client.toString() + " already exists.");
        }
        else {
//            Singletone.writeData(client, ClientsFileName);
//            Singletone.writeData((Person) client, PeopleFileName);
            clients.add(client);

            Collections.sort(clients, new SortClients());
        }
    }

    public void addSpecialClient(String name, String CNP) {
        // Adds new pro client to csv for ordinary clients and to csv for arr clients.
        ProClient proClient = new ProClient(name, CNP);
        if (clients.contains(proClient)) {
            System.out.println(proClient.toString() + " already exists.");
        }
        else {
//            Singletone.writeData(proClient, ProClientsFileName);
//            Singletone.writeData((Person) proClient, PeopleFileName);
            clients.add(proClient);

            Collections.sort(clients, new SortClients());
        }
    }

    @Override
    public String toString() {
        String str = "Clients are: ";
        for( Person c:clients) {
            str = str + c.toString() + ", ";
        }

        return str;
    }

    //add a binary search
    public Person searchClient( String name, String cnp) {
        for(Person client:clients) {
            if( client.getName().equals(name) &&  client.getCNP().equals(cnp)) {
                return client;
            }
        }

        this.addClient(name, cnp);
        return this.searchClient(name, cnp);
    }


}
