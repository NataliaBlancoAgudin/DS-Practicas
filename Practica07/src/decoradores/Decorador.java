package decoradores;

import fileSystem.Salida;

import java.io.IOException;

public abstract class Decorador implements Salida {
    private Salida salida;

    public Decorador(Salida salida) {
        this.salida = salida;
    }

    @Override
    public void write(char c) throws IOException {
        salida.write(c);
    }

    @Override
    public void close() throws IOException {
        salida.close();
    }
}
