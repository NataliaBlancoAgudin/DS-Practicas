package alineacion;

import model.Line;

public class AlineacionIzquierda implements Alineacion {
    @Override
    public String alinear(Line line, int lineWidth) {
        return line.getContent();
    }
}
