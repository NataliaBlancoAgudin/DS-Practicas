package herramientas;

import cambios.CambiosCreacion;
import editor.Editor;
import figuras.Figura;
import figuras.cuadrado.Cuadrado;

import java.awt.*;

public abstract class HerramientaCreacion implements Herramienta {

    private Editor editor;
    private Point puntoInicial;

    protected HerramientaCreacion(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void pinchar(int x, int y) {
        this.puntoInicial = new Point(x, y);
    }

    @Override
    public void soltar(int x, int y) {
        Point puntoFinal = new Point(x, y);
        Figura figura = crearFigura(puntoInicial, puntoFinal);
        editor.getDibujo().addFigura(figura);

        // Lo añadimos en el historial
        editor.getHistorial().addCambios(new CambiosCreacion(figura, editor.getDibujo()));

        // Volvemos a la herramienta por defecto
        editor.finHerramienta();
    }

    @Override
    public void mover(int x, int y) {
        // nada
    }

    protected abstract Figura crearFigura(Point puntoInicial, Point puntoFinal);
}
