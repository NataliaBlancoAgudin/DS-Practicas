package fileSystem;

import java.io.StringWriter;

public class Bluetooth implements Salida{

    private StringWriter stringWriter;

    public Bluetooth(String nombre){
        stringWriter = new StringWriter();
        stringWriter.append("\n--- START. Conectando con Bluetooth[" + nombre + "]\n");
    }

    @Override
    public void write(char c) {
        stringWriter.append(c);
    }

    @Override
    public void close() {
        System.out.print(stringWriter.toString());
        System.out.println("--- END. Cerrando conexión Bluetooth");
    }
}
