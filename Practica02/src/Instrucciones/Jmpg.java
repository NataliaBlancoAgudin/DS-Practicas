package Instrucciones;

import Programa.Programa;

public class Jmpg implements Instruccion {

    private int valor;

    public Jmpg(int valor) {
        this.valor = valor;
    }

    @Override
    public void execute(Programa programa) {
        int b = programa.getPila().pop();
        int a = programa.getPila().pop();
        if (a > b)
            programa.setIp(valor);
        else
            programa.setIp(programa.getIp() + 1);
    }
}
