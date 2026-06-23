package modos;

import editor.Editor;
import instrucciones.InstruccionCommand;
import instrucciones.Macro;
import model.Document;

// Interfaz State -> Los modos pueden ser de 3 tipos y pueden pasar de un modo a otro.
// Además, esta interfaz actúa como el invoker del patrón Command
public interface Modo {
    void open(String nombre);
    void insert(String text);
    void delete();
    void replace(String textoAReemplazas, String textoReemplazo);
    void stop();
    void play(String name);

    String getName();
}
