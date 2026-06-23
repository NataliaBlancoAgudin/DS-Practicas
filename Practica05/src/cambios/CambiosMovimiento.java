package cambios;

import figuras.Figura;

public class CambiosMovimiento implements Cambios{

    private Figura figura;
    private int dx, dy;

    public CambiosMovimiento(Figura figura, int dx, int dy) {
        this.figura = figura;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void undo() {
        figura.mover(-dx, -dy);
    }

    @Override
    public void redo() {
        figura.mover(dx, dy);
    }
}
