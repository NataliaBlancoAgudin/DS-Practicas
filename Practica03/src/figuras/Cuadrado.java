package figuras;

public class Cuadrado implements Figura{

    private int x, y, ancho, alto;

    public Cuadrado(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public void dibujar() {
        System.out.println("Cuadrado: x = " + x + ", y = " + y + ", ancho = " + ancho + ", alto = " + alto);
    }

    @Override
    public boolean contiene(int x, int y) {
        return (x >= this.x && x <= this.x + ancho && y >= this.y && y <= this.y + alto);
    }

    @Override
    public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
