package videoclub;

public class Alquiler {
    private Pelicula pelicula;
    private int dias;
    private double precioAlquiler;
    private int puntosAlquiler;

    public Alquiler(Pelicula pelicula, int dias) {
        this.pelicula = pelicula;
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public double getPrecioAlquiler() {
        precioAlquiler = pelicula.getPrecioAlquiler(this);
        return precioAlquiler;
    }

    public int getPuntosAlquiler() {
        puntosAlquiler = pelicula.getPuntosAlquiler(this);
        return puntosAlquiler;
    }

}
