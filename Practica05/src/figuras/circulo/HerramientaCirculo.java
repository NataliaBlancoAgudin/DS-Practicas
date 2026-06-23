package figuras.circulo;

import editor.Editor;
import figuras.Figura;
import herramientas.Herramienta;
import herramientas.HerramientaCreacion;

import java.awt.*;

public class HerramientaCirculo extends HerramientaCreacion {

    public HerramientaCirculo(Editor editor) {
        super(editor);
    }

    @Override
    protected Figura crearFigura(Point puntoInicial, Point puntoFinal) {
        int radio = (puntoFinal.x - puntoInicial.x) / 2;
        int centroX = puntoInicial.x + radio;
        int centroY = puntoInicial.y + (puntoFinal.y - puntoInicial.y) / 2;
        return new Circulo(new Point(centroX, centroY), radio);
    }
}
