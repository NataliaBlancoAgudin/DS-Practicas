package command;

import editor.Editor;

import java.util.List;

public class InsertaCommand implements InstruccionCommand {

    private String[] listaInsercion;

    public InsertaCommand(String[] listaInsercion) {
        if (listaInsercion == null || listaInsercion.length == 0)
            throw new IllegalArgumentException("Se necesita al menos una palabra a insertar");
        this.listaInsercion = listaInsercion;
    }

    @Override
    public void execute(Editor editor) {
        editor.insertar(listaInsercion);
    }
}
