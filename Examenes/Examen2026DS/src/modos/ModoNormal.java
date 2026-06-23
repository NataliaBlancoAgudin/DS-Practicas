package modos;

import editor.Editor;
import instrucciones.*;
import model.Document;

import java.io.IOException;

// Clase concreta: ConcreteState -> implementa los metodos de la interfaz State
public class ModoNormal implements Modo {

    private Document document;
    private Editor editor;

    public ModoNormal(Editor editor, Document document) {
        this.document = document;
        this.editor = editor;
    }

    @Override
    public void open(String nombre) {
        try {
            Document documento = Document.fromFile(nombre);
            editor.getDocument().setContent(documento.getContent());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    @Override
    public void insert(String text) {
        InstruccionCommand insert = new InsertCommand(text);
        insert.execute(document);
    }

    @Override
    public void delete() {
        InstruccionCommand delete = new DeleteCommand();
        delete.execute(document);
    }

    @Override
    public void replace(String textoAReemplazas, String textoReemplazo) {
        InstruccionCommand replace = new ReplaceCommand(textoAReemplazas, textoReemplazo);
        replace.execute(document);

    }

    @Override
    public void stop() {
        // nada
    }

    @Override
    public void play(String name) {
        editor.getActionManager().ejecutar(name);
    }

    @Override
    public String getName() {
        return "Normal";
    }
}
