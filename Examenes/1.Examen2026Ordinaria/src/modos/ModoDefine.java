package modos;

import editor.ActionManager;
import editor.Editor;
import instrucciones.*;
import model.Document;

import java.io.IOException;
import java.util.List;

public class ModoDefine implements Modo {

    private Editor editor;

    public ModoDefine(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void open(String nombre) {
        ActionManager action = editor.getActionManager();
        action.parar();

        try {
            Document documento = Document.fromFile(nombre);
            editor.getDocument().setContent(documento.getContent());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        editor.setModoActual(new ModoNormal(editor, editor.getDocument()));
    }

    @Override
    public void insert(String text) {
        InstruccionCommand insert = new InsertCommand(text);
        editor.getActionManager().getMacro().addInstruccion(insert);
    }

    @Override
    public void delete() {
        InstruccionCommand delete = new DeleteCommand();
        editor.getActionManager().getMacro().addInstruccion(delete);
    }

    @Override
    public void replace(String textoAReemplazas, String textoReemplazo) {
        InstruccionCommand replace = new ReplaceCommand(textoAReemplazas, textoReemplazo);
        editor.getActionManager().getMacro().addInstruccion(replace);
    }

    @Override
    public void stop() {
        editor.getActionManager().parar();
    }

    @Override
    public void play(String name) {
        List<InstruccionCommand> instruccionesMacro = editor.getActionManager().getInstrucciones(name);
        for(InstruccionCommand instruccion : instruccionesMacro) {
            editor.getActionManager().getMacro().addInstruccion(instruccion);
        }
    }

    @Override
    public String getName() {
        return "Define";
    }
}
