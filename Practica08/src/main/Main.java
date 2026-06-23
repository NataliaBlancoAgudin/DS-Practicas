package main;

import java.io.*;

import encuesta.*;
import observers.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");
        GraficoCircular graficoCircular = new GraficoCircular();
        GraficoBarras graficoBarras = new GraficoBarras();
        BaseDatos baseDatos = new BaseDatos();

        encuesta.addObserver(graficoCircular);
        encuesta.addObserver(graficoBarras);
        encuesta.addObserver(baseDatos);

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }

}

class Main1 {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");
        GraficoCircular graficoCircular = new GraficoCircular();
        GraficoBarras graficoBarras = new GraficoBarras();
        BaseDatos baseDatos = new BaseDatos();
        LineaEstado lineaEstado = new LineaEstado();

        encuesta.addObserver(graficoCircular);
        encuesta.addObserver(graficoBarras);
        encuesta.addObserver(baseDatos);
        encuesta.addObserver(lineaEstado);

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }
}

class Main2 {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");
        GraficoCircular graficoCircular = new GraficoCircular();
        BaseDatos baseDatos = new BaseDatos();
        LineaEstado lineaEstado = new LineaEstado();

        encuesta.addObserver(graficoCircular);
        encuesta.addObserver(baseDatos);
        encuesta.addObserver(lineaEstado);

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }
}

class Main3 {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");
        GraficoCircular graficoCircular = new GraficoCircular();
        BaseDatos baseDatos = new BaseDatos();
        LineaEstado lineaEstado = new LineaEstado();
        Activador activar = new Activador(graficoCircular, 3);

        encuesta.addObserver(baseDatos);
        encuesta.addObserver(lineaEstado);
        encuesta.addObserver(activar);

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }
}

class Main4 {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");
        GraficoCircular graficoCircular = new GraficoCircular();
        GraficoBarras graficoBarras = new GraficoBarras();
        BaseDatos baseDatos = new BaseDatos();
        LineaEstado lineaEstado = new LineaEstado();
        Intervalo intervalo = new Intervalo(graficoBarras, 3);

        encuesta.addObserver(baseDatos);
        encuesta.addObserver(lineaEstado);
        encuesta.addObserver(graficoCircular);
        encuesta.addObserver(intervalo);

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }
}

class Main5 {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");
        GraficoCircular graficoCircular = new GraficoCircular();
        GraficoBarras graficoBarras = new GraficoBarras();
        BaseDatos baseDatos = new BaseDatos();
        Intervalo intervalo = new Intervalo(graficoBarras, 3);

        LineaEstado lineaEstado = new LineaEstado();
        Intervalo intervaloLinea = new Intervalo(lineaEstado, 2);
        Activador activador = new Activador(intervaloLinea, 4);

        encuesta.addObserver(baseDatos);
        encuesta.addObserver(graficoCircular);
        encuesta.addObserver(intervalo);
        encuesta.addObserver(activador);

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }
}