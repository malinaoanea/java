package streams;

import java.io.*;

public class Ex2 {
    private static final String BASE_ATH = "./src/streams/";

    public static void main(String[] args) {
        try(FileReader fr = new FileReader(BASE_ATH + "file1.txt") ;
            FileWriter fw = new FileWriter(new File(BASE_ATH + "file2.txt" ))){
            int c;
            while ((c = fr.read()) != -1){
                fw.write(c);
            }
        }

        catch (IOException e){
            e.printStackTrace();

        }

        try(FileInputStream fis = new FileInputStream(BASE_ATH + "file2.txt");
        FileOutputStream fos = new FileOutputStream(BASE_ATH + "file1.txt")) {
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.read();
            fos.write(buffer);

        }
        catch ( IOException e ) {
            System.out.println(e);
        }


    }
}
