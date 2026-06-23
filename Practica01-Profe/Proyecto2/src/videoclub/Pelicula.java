package videoclub;

public class Pelicula {
    private String titulo;
    private int categoria;

    public static final int NORMAL = 0;
    public static final int NOVEDAD = 1;
    public static final int INFANTIL = 2;

    public Pelicula(String titulo, int categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }
}
