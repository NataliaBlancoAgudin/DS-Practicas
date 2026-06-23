package decoradores;

import fileSystem.Salida;

import java.io.IOException;

public class Encripador extends Decorador{

    public Encripador(Salida salida) {
        super(salida);
    }

    @Override
    public void write(char c) throws IOException {
        if(Character.isLetterOrDigit(c))
            super.write((char) (c + 1));
    }
}
