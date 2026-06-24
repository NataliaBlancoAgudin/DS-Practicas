package modos;

public interface Modo {
    void open(String nombre);
    void insert(String text);
    void delete();
    void replace(String textoAReemplazas, String textoReemplazo);
    void stop();
    void play(String name);
    String getName();
}
