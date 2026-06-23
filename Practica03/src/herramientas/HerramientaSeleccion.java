package herramientas;

import editor.Editor;
import figuras.Figura;

public class HerramientaSeleccion implements Herramienta {

    private int xRef, yRef;
    private Figura figuraMovimiento;
    private Editor editor;

    public HerramientaSeleccion(Editor editor){
        this.editor = editor;
    }

    @Override
    public void pinchar(int x, int y) {
        xRef = x;
        yRef = y;
        figuraMovimiento = editor.getDibujo().getFigura(x, y);
    }

    @Override
    public void soltar(int x, int y) {
        figuraMovimiento.mover(x-xRef, y-yRef);
        figuraMovimiento = null;
    }

    @Override
    public void mover(int x, int y) {
        if(figuraMovimiento != null){
            figuraMovimiento.mover(x-xRef, y-yRef);
            xRef = x;
            yRef = y;
        }
    }
}
