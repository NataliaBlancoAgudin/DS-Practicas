package decoradores;

import fileSystem.Salida;

import java.io.IOException;

public class Normalizador extends Decorador{

    public Normalizador(Salida salida) {
        super(salida);
    }

    @Override
    public void write(char c) throws IOException {
        if(c != '\r')
            super.write(c);
    }
}
