package figuras;

// Interfaz Figura: todas las figuras saben dibujarse, saben identificar si estan en unas coordenadas y saben moverse
public interface Figura {
    void dibujar();
    boolean contiene(int x, int y);
    void mover(int dx, int dy);
}
