package fileSystem;

import java.io.StringWriter;

public class Internet implements Salida{

    private StringWriter stringWriter;

    public Internet(String nombre) {
        stringWriter = new StringWriter();
        stringWriter.append("\n--- START. Conectando a Internet[" + nombre + "]\n");
    }

    @Override
    public void write(char c) {
        stringWriter.append(c);
    }

    @Override
    public void close() {
        System.out.print(stringWriter.toString());
        System.out.println("--- END. Cerrando conexión a Internet");
    }
}
