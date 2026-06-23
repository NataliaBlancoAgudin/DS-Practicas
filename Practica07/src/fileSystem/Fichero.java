package fileSystem;

import java.io.FileWriter;
import java.io.IOException;

public class Fichero implements Salida{

    private FileWriter writer;

    public Fichero(String nombreDestino) throws IOException {
        writer = new FileWriter(nombreDestino);
    }

    @Override
    public void write(char c) throws IOException {
        writer.append(c);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
