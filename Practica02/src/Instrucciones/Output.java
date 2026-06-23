package Instrucciones;

import Programa.Programa;

public class Output implements Instruccion {

    @Override
    public void execute(Programa programa) {
        System.out.println(programa.getPila().pop());
        programa.setIp(programa.getIp() + 1);
    }
}
