package editor;

import figuras.*;
import herramientas.*;

import java.awt.*;
import java.io.*;

public class Editor {

    // Creamos un nuevo atributo para saber cual es la herramienta actual que estamos utilizando
    private String herramientaActual = "seleccion";
    private Herramienta herramienta, herramientaDefecto;

    public Editor() {
        setDibujo(new Dibujo());

        herramientaDefecto = herramienta = new HerramientaSeleccion(this);
    }

    public Herramienta getHerramientaDefecto() {
        return herramientaDefecto;
    }

    public void finHerramienta(){
        herramienta = herramientaDefecto;
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
            if (line[0].equals("cuadrado"))
                herramienta = new HerramientaCuadrado(this);
            else if (line[0].equals("circulo"))
                herramienta = new HerramientaCirculo(this);
            else if (line[0].equals("triangulo"))
                herramienta = new HerramientaTriangulo(this);
            else if (line[0].equals("seleccion"))
                herramienta = new HerramientaSeleccion(this);
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
        if(herramientaActual.equals("triangulo")){
            System.out.println("Botón activo: Herramienta que crea triangulos");
        }
        else if(herramientaActual.equals("circulo")){
            System.out.println("Botón activo: Herramienta que crea circulos");
        }
        else if(herramientaActual.equals("cuadrado")){
            System.out.println("Botón activo: Herramienta que crea cuadrados");
        }
        else if(herramientaActual.equals("seleccion")){
            System.out.println("Botón activo: Herramienta de Selección");
        }

        dibujo.dibujar();
    }

    private Dibujo dibujo;
}
