package Instrucciones;

import Programa.Programa;

public class Store implements Instruccion {

    @Override
    public void execute(Programa programa) {
        int valor = programa.getPila().pop();
        int direccion = programa.getPila().pop();
        programa.getMemoria().setValor(direccion, valor);
        programa.setIp(programa.getIp() + 1);
    }
}
