package Instrucciones;

import Programa.Programa;

import java.util.Scanner;

public class Input implements Instruccion {

    private static Scanner console = new Scanner(System.in);

    @Override
    public void execute(Programa programa) {
        System.out.println("Escriba un entero:");
        programa.getPila().push(console.nextInt());
        programa.setIp(programa.getIp() + 1);
    }
}
