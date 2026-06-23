package Instrucciones;

import Programa.Programa;

public class Sub implements Instruccion {

    @Override
    public void execute(Programa programa) {
        int b = programa.getPila().pop();
        int a = programa.getPila().pop();
        programa.getPila().push(a - b);
        programa.setIp(programa.getIp() + 1);
    }
}
