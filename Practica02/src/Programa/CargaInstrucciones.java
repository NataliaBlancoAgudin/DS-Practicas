package Programa;

import Instrucciones.*;

public class CargaInstrucciones {

    public static Instruccion crearInstruccion(String linea) {
        String[] palabras = linea.split(" ");

        Instruccion instruccion = null;

        if (palabras[0].equals("push")) {
            instruccion = new Push(Integer.parseInt(palabras[1]));
        } else if (palabras[0].equals("add")) {
            instruccion = new Add();
        } else if (palabras[0].equals("sub")) {
            instruccion = new Sub();
        } else if (palabras[0].equals("mul")) {
            instruccion = new Mul();
        } else if (palabras[0].equals("jmp")) {
            instruccion = new Jmp(Integer.parseInt(palabras[1]));
        } else if (palabras[0].equals("jmpg")) {
            instruccion = new Jmpg(Integer.parseInt(palabras[1]));
        } else if (palabras[0].equals("load")) {
            instruccion = new Load();
        } else if (palabras[0].equals("store")) {
            instruccion = new Store();
        } else if (palabras[0].equals("input")) {
            instruccion = new Input();
        } else if (palabras[0].equals("output")) {
            instruccion = new Output();
        }

        return instruccion;
    }
}
