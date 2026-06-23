package editor;

import instrucciones.InstruccionCommand;
import instrucciones.Macro;
import model.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionManager {

    private Macro macro;
    private Map<String, Macro> savedMacros;

    private Document document;

    public ActionManager(Document document) {
        this.document = document;
        this.savedMacros = new HashMap<>();
    }

    public void execute(InstruccionCommand instruccion) {
        instruccion.execute(document);
    }

    public void grabar(String nombreMacro){
        macro = new Macro(nombreMacro);
    }

    public void parar(){
        savedMacros.put(macro.getNombre(), macro);
    }

    public void ejecutar(String nombre){
        Macro macro = savedMacros.get(nombre);
        macro.execute(document);
    }

    public Macro getMacro() {
        return macro;
    }

    public List<InstruccionCommand> getInstrucciones(String name) {
        return savedMacros.get(name).getInstrucciones();
    }
}
