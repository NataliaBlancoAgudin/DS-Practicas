package videoclub;

public class PeliculaInfantil implements Pelicula{
    private String titulo;

    public PeliculaInfantil(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public double getPrecioAlquiler(Alquiler alquiler) {
        double precioAlquiler = 1.5;
        if (alquiler.getDias() > 3)
            precioAlquiler += (alquiler.getDias() - 3) * 1.5;
        return precioAlquiler;
    }

    @Override
    public int getPuntosAlquiler(Alquiler alquiler) {
        return 1;
    }
}
