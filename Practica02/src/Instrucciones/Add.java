package Instrucciones;

import Programa.Programa;

public class Add implements Instruccion {

    @Override
    public void execute(Programa programa) {
        programa.getPila().push(programa.getPila().pop() + programa.getPila().pop());
        programa.setIp(programa.getIp() + 1);
    }
}
