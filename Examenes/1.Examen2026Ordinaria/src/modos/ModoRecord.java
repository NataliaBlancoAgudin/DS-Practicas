package modos;

import editor.Editor;
import instrucciones.*;
import model.Document;

import java.util.List;

public class ModoRecord implements Modo {

    private Document document;
    private Editor editor;

    public ModoRecord(Editor editor, Document document) {
        this.document = document;
        this.editor = editor;
    }

    @Override
    public void open(String nombre) {
        System.out.println(">>> Opening a file is not allowed while recording a macro");
    }

    @Override
    public void insert(String text) {
        InstruccionCommand insert = new InsertCommand(text);
        insert.execute(document);
        editor.getActionManager().getMacro().addInstruccion(insert);
    }

    @Override
    public void delete() {
        InstruccionCommand delete = new DeleteCommand();
        delete.execute(document);
        editor.getActionManager().getMacro().addInstruccion(delete);
    }

    @Override
    public void replace(String textoAReemplazas, String textoReemplazo) {
        InstruccionCommand replace = new ReplaceCommand(textoAReemplazas, textoReemplazo);
        replace.execute(document);
        editor.getActionManager().getMacro().addInstruccion(replace);
    }

    @Override
    public void stop() {
        editor.getActionManager().parar();
        editor.setModoActual(new ModoNormal(editor, document));
    }

    @Override
    public void play(String name) {
        editor.getActionManager().ejecutar(name);

        List<InstruccionCommand> instruccionesMacro = editor.getActionManager().getInstrucciones(name);
        for(InstruccionCommand instruccion : instruccionesMacro) {
            editor.getActionManager().getMacro().addInstruccion(instruccion);
        }
    }
    @Override
    public String getName() {
        return "Record";
    }
}
