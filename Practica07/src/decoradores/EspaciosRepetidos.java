package decoradores;

import fileSystem.Salida;

import java.io.IOException;

public class EspaciosRepetidos extends Decorador {

    private char primerEspacio = 0;

    public EspaciosRepetidos(Salida salida) {
        super(salida);
    }

    @Override
    public void write(char c) throws IOException {
        if(c == ' ' && primerEspacio == ' ') {
            return;
        }
        super.write(c);
        primerEspacio = c;
    }
}
