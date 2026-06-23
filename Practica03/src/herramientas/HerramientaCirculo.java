package herramientas;

import editor.Editor;
import figuras.Circulo;
import figuras.Figura;

import java.awt.*;

public class HerramientaCirculo implements Herramienta {

    private int initialX, initialY;
    private Editor editor;

    public HerramientaCirculo(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void pinchar(int x, int y) {
        this.initialX = x;
        this.initialY = y;
    }

    @Override
    public void soltar(int x, int y) {
        int radio = (x - initialX) / 2;
        int centroX = initialX + radio;
        int centroY = initialY + (y - initialY) / 2;
        Figura circulo = new Circulo(new Point(centroX, centroY), radio);
        editor.getDibujo().addFigura(circulo);
        // Volvemos a la herramienta por defecto
        editor.finHerramienta();
    }

    @Override
    public void mover(int x, int y) {
        // No se hace nada
    }
}
