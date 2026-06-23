package editor;

import command.InstruccionCommand;
import command.Macro;

import java.util.HashMap;
import java.util.Map;

public class ActionManager {

    private static boolean isGrabando = false;
    private static Macro macro;
    private static Map<String, Macro> macros = new HashMap<String, Macro>();
    private static Editor editor;

    public ActionManager(Editor editor) {
        this.editor = editor;
    }

    public void execute(InstruccionCommand command) {
        if(!isGrabando)
            command.execute(editor);
        else
            macro.add(command);
    }

    public void grabar(String nombre) {
        isGrabando = true;
        macro = new Macro(nombre);
    }

    public void parar(){
        isGrabando = false;
        macros.put(macro.getNombre(), macro);
    }

    public void ejecutarGrabacion(String nombre){
        Macro macro = macros.get(nombre);
        execute(macro);
    }

}
