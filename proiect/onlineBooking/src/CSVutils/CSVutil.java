package CSVutils;

import java.io.*;
import java.util.ArrayList;

public abstract class CSVutil {

    public void saveData(String fileName, String... data) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            if ( data.length == 0)
                fileWriter.write(this.toCSV()  + '\n');
            else fileWriter.write(this.toCSV() + "," + data[0] + "," + data[1] + "," + this.getType() + "\n");
            fileWriter.close();
            System.out.println("Successfully wrote data to " + fileName + ".");

        } catch (IOException e) {
            System.out.println("Couldn't open " + fileName +".");
            e.printStackTrace();
        }

    }


    public boolean search(String name, String fileName) {
        // in each csv file, the first column contains the name
        // returns the info in csv about sth, if didn't find returns null
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while ( line != null ) {
                String[] lineAt = line.split(",");
                if ( lineAt[0] == name ) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't open " + fileName +".");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Couldn't open " + fileName +".");
            e.printStackTrace();
        }
        return false;
    }

    protected abstract String toCSV();
    protected abstract String getType();
}
