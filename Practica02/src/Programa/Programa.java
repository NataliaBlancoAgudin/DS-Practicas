package Programa;

import Instrucciones.Instruccion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    private static List<Instruccion> instrucciones = new ArrayList<Instruccion>();
    private static int ip = 0;

    private String nombreFichero;

    private static Memoria memoria = new Memoria();
    private static Pila pila = new Pila();

    public Programa(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public void ejecutarPrograma() throws Exception {
        BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

        String linea;
        while ((linea = fichero.readLine()) != null)
            cargaInstruccion(linea);
        fichero.close();

        ejecutaPrograma();
    }


    // $ Cargar programa --------------------------------
    private static void cargaInstruccion(String linea) {
        if (linea.trim().length() == 0)
            return;

        String[] palabras = linea.split(" ");
        instrucciones.add(CargaInstrucciones.crearInstruccion(linea));
    }

    // $ Motor de Ejecución --------------------------------
    private void ejecutaPrograma() {
        while (ip < instrucciones.size()) {
            Instruccion instruccion = instrucciones.get(ip);
            instruccion.execute(this);
        }
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public Pila getPila() {
        return pila;
    }

    public int getIp(){
        return ip;
    }

    public void setIp(int ip){
        this.ip = ip;
    }

}
