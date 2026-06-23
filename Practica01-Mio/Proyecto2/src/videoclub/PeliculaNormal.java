package videoclub;

public class PeliculaNormal implements Pelicula{
    private String titulo;

    public PeliculaNormal(String titulo){
        this.titulo = titulo;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public double getPrecioAlquiler(Alquiler alquiler) {
        double precioAlquiler = 2;
        if (alquiler.getDias() > 2)
            precioAlquiler += (alquiler.getDias() - 2) * 1.5;
        return precioAlquiler;
    }

    @Override
    public int getPuntosAlquiler(Alquiler alquiler) {
        return 1;
    }
}
