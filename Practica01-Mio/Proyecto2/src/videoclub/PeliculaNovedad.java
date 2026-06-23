package videoclub;

public class PeliculaNovedad implements Pelicula{
    private String titulo;
    private double precioAlquiler;

    public PeliculaNovedad(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public double getPrecioAlquiler(Alquiler alquiler) {
        precioAlquiler += alquiler.getDias() * 3;
        return precioAlquiler;
    }

    @Override
    public int getPuntosAlquiler(Alquiler alquiler) {
        int puntosAlquiler = 1;
        if(alquiler.getDias() > 1)
            puntosAlquiler = 2;
        return puntosAlquiler;
    }
}
