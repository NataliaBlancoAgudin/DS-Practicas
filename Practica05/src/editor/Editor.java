package editor;

import figuras.*;
import herramientas.*;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Editor {

    private Map<String, Herramienta> herramientas = new HashMap<>();

    private Herramienta herramienta, herramientaDefecto;

    private Historial historial;

    public Editor() {
        setDibujo(new Dibujo());

        herramientaDefecto = herramienta = crearHerramientaPorDefecto();

        historial = new Historial();
    }

    public void registrarHerramienta(String nombre, Herramienta herramienta) {
        herramientas.put(nombre, herramienta);
    }

    public void cambiarHerramientaPorDefecto(String nombre){
        if(herramientas.containsKey(nombre)){
            herramientaDefecto = herramientas.get(nombre);
        }
    }

    public Herramienta crearHerramientaPorDefecto(){
        Herramienta seleccion = new HerramientaSeleccion(this);
        herramientas.put("seleccion", seleccion);
        return seleccion;
    }

    public Herramienta getHerramientaDefecto() {
        return herramientaDefecto;
    }

    public void setHerramientaActual(Herramienta herramientaActual) {
        this.herramienta = herramientaActual;
    }

    public void finHerramienta(){
        herramienta = getHerramientaDefecto();
    }

    public Historial getHistorial() {
        return historial;
    }

    public void run() throws IOException {

        System.out.println("Comandos de Herramientas: cuadrado | circulo | triangulo | seleccion");
        System.out.println("Comandos de Ratón: pinchar x,y | mover x,y | soltar x,y");
        System.out.println("Otros Comandos: dibujar | exit");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print(">");
            String[] line = in.readLine().split("[ ,]");

            if (line[0].equals("exit"))
                return;


            else if (line[0].equals("pinchar")) {
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                herramienta.pinchar(x, y);
            } else if (line[0].equals("mover")) { // Esto es mover el ratón
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                herramienta.mover(x, y);
            } else if (line[0].equals("soltar")) {
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                herramienta.soltar(x, y);
            } else if (line[0].equals("dibujar"))
                dibujar();
            else if(herramientas.keySet().contains(line[0]))
                setHerramientaActual(herramientas.get(line[0]));
            else if(line[0].equals("undo"))
                historial.undo();
            else if(line[0].equals("redo"))
                historial.redo();
            else
                System.out.println("Comando no válido");

        } while (true);
    }

    //$ Métodos del dibujo -----------------------------

    public void setDibujo(Dibujo dibujo) {
        this.dibujo = dibujo;
    }

    public Dibujo getDibujo() {
        return dibujo;
    }

    public void dibujar() {
        // Dibujar menú
        // Dibujar barra de herramientas lateral
        // Dibujar línea de estado

        System.out.println("Herramienta: " + herramienta);
        dibujo.dibujar();
    }

    private Dibujo dibujo;
}
