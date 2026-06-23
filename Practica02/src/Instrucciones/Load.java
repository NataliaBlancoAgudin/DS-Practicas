package Instrucciones;

import Programa.Programa;

public class Load implements Instruccion {

    @Override
    public void execute(Programa programa) {
        int direccion = programa.getPila().pop();
        programa.getPila().push(programa.getMemoria().getValor(direccion));
        programa.setIp(programa.getIp() + 1);
    }
}
