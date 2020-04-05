import client.Client;
import client.Person;

import java.util.Comparator;

public class SortClients implements Comparator<Person> {
    public  int compare(Person a, Person b) {
        return  a.getName().compareTo(b.getName());

    }
}
