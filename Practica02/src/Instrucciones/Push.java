package Instrucciones;

import Programa.Programa;

public class Push implements Instruccion {

    private int valor;

    public Push(int valor) {
        this.valor = valor;
    }

    @Override
    public void execute(Programa programa) {
        programa.getPila().push(valor);
        programa.setIp(programa.getIp() + 1);
    }
}
