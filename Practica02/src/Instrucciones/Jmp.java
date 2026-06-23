package Instrucciones;

import Programa.Programa;

public class Jmp implements Instruccion {

    private int valor;

    public Jmp(int valor) {
        this.valor = valor;
    }

    @Override
    public void execute(Programa programa) {
        programa.setIp(valor);
    }
}
