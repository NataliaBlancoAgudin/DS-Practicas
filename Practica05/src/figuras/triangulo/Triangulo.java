package figuras.triangulo;

import figuras.Figura;

import java.awt.*;

public class Triangulo implements Figura {

    private Point v1, v2, v3;

    public Triangulo(Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public void dibujar() {
        System.out.println("Triangulo: v1 = " + v1 + ", v2 = " + v2 + ", v3 = " + v3);
    }

    @Override
    public boolean contiene(int x, int y) {
        Point p = new Point(x, y);
        return p.equals(v1) || p.equals(v2) || p.equals(v3);
    }

    @Override
    public void mover(int dx, int dy) {
        v1.translate(dx, dy);
        v2.translate(dx, dy);
        v3.translate(dx, dy);
    }


}
