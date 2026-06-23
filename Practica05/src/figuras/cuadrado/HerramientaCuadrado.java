package figuras.cuadrado;

import editor.Editor;
import figuras.Figura;
import herramientas.Herramienta;
import herramientas.HerramientaCreacion;

import java.awt.*;

public class HerramientaCuadrado extends HerramientaCreacion {

    public HerramientaCuadrado(Editor editor) {
        super(editor);
    }

    @Override
    protected Figura crearFigura(Point puntoInicial, Point puntoFinal) {
        return new Cuadrado(puntoInicial, puntoFinal);
    }
}
