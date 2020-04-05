import client.Client;
import client.Person;
import client.ProClient;
import java.util.ArrayList;
import java.util.Collections;

public class DBClients {
    ArrayList<Person> clients;

    public DBClients() {
        clients = new ArrayList<Person>();
    }

    public void addClient(String name, String CNP) {
        clients.add( new Client(name, CNP));
        Collections.sort(clients, new SortClients());
    }

    public void addSpecialClient(String name, String CNP) {
        clients.add( new ProClient(name, CNP));
        Collections.sort(clients, new SortClients());
    }

    @Override
    public String toString() {
        String str = "Client are: ";

        for( Person c:clients) {
            str = str + c.toString() + " ";
        }

        return str;
    }

    //add a binary search
    public Person searchClient( String name, String cnp) {
        for(Person client:clients) {
            if( client.getName() == name &&  client.getCNP() == cnp) {
                return client;
            }
        }

        this.addClient(name, cnp);
        return this.searchClient(name, cnp);
    }
}
