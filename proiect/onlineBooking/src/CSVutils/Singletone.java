package CSVutils;

import client.Client;
import client.Person;
import client.ProClient;
import event.Concert;
import event.Event;
import location.Location;

import java.io.*;
import java.util.ArrayList;

public class Singletone {
    private static Singletone instance = null;

    private Singletone(){}
    public static Singletone getInstance(){
        if (instance == null) {
            instance = new Singletone();
        }
        return instance;
    }

    public static void getData(String fileName, String ClientsFileName, String ProClientsFileName, ArrayList<Person> clients ) {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader( new FileReader(fileName) );
            // it will not work if there is an empty file
            while ( (line = bufferedReader.readLine()) != null ) {
                String[] lineAt = line.split(",");
                if( fileName ==  ClientsFileName)
                    clients.add(new Client(lineAt[0], lineAt[1]));
                else if ( fileName == ProClientsFileName )
                    clients.add( new ProClient(lineAt[0], lineAt[1]) );
            }

        } catch (FileNotFoundException e) {
            System.out.println("No previous info in " + fileName +".");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private void csvWriter( String data, String fileName ) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(data + "\n");
            fileWriter.close();
            System.out.println("Updated " + fileName +".");

        } catch (IOException e) {
            System.out.println("Error when updating " + fileName +".");
            e.printStackTrace();
        }
    }

    public static void updateAudit(String data, String fileName) {
        getInstance().csvWriter(data, fileName);
    }
//    private void csvWriter( Client client, String fileName ) {
//        client.saveData(fileName);
//    }

//    public static void writeData (Client client, String fileName) {
//            getInstance().csvWriter(client, fileName);
//    }

//    private void csvWriter(ProClient proClient, String fileName ) {
//        proClient.saveData(fileName);
//    }

//    public static void writeData (ProClient proClient, String fileName) {
//        getInstance().csvWriter(proClient, fileName);
//    }

//    private void csvWriter(Person person, String fileName ) {
//        person.saveData(fileName);
//    }

//    public static void writeData (Person person, String fileName) {
//        getInstance().csvWriter(person, fileName);
//    }

//    private void csvWriter(Event event, String fileName, String location, String date, String type ) {
//        event.saveData(fileName, location, date, type);
//    }

//    public static void writeData (Event event, String fileName, String location, String date, String type) {
//        getInstance().csvWriter(event, fileName, location, date, type);
//    }

}
