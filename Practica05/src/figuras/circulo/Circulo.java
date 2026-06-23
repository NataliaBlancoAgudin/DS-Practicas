package figuras.circulo;

import figuras.Figura;

import java.awt.*;

public class Circulo implements Figura {

    private Point centro;
    private int radio;

    public Circulo(Point centro, int radio) {
        this.centro = centro;
        this.radio = radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Círculo: centro = " + centro + ", radio = " + radio);
    }

    @Override
    public boolean contiene(int x, int y) {
        return Math.sqrt(Math.pow(x - centro.x, 2) + Math.pow(y - centro.y, 2)) < radio;
    }

    @Override
    public void mover(int dx, int dy) {
        centro.translate(dx, dy);
    }


}
