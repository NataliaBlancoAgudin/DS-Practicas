package fileSystem;

import java.io.*;

public class FileSystem {

    public void procesarFichero(String name, Salida salida) {
        try {
            FileReader reader = new FileReader(name);

            int c;
            while ((c = reader.read()) != -1)
                salida.write((char) c);

            reader.close();
            salida.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
