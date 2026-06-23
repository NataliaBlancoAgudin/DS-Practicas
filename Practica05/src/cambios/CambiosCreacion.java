package cambios;

import editor.Dibujo;
import editor.Editor;
import figuras.Figura;

public class CambiosCreacion implements Cambios {

    private Figura figura;
    private Dibujo dibujo;

    public CambiosCreacion(Figura figura, Dibujo dibujo) {
        this.figura = figura;
        this.dibujo = dibujo;
    }

    @Override
    public void undo() {
        dibujo.removeFigura(figura);
    }

    @Override
    public void redo() {
        dibujo.addFigura(figura);
    }
}
