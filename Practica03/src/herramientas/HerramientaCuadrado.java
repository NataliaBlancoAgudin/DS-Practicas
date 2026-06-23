package herramientas;

import editor.Editor;
import figuras.Cuadrado;
import figuras.Figura;

public class HerramientaCuadrado implements Herramienta {

    private int initialX, initialY;
    private Editor editor;

    public HerramientaCuadrado(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void pinchar(int x, int y) {
        this.initialX = x;
        this.initialY = y;
    }

    @Override
    public void soltar(int x, int y) {
        Figura cuadrado = new Cuadrado(initialX, initialY, x - initialX, y - initialY);
        editor.getDibujo().addFigura(cuadrado);
        // Volvemos a la herramienta por defecto
        editor.finHerramienta();
    }

    @Override
    public void mover(int x, int y) {
        // No se hace nada
    }
}
