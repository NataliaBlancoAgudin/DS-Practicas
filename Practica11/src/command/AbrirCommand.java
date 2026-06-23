package command;

import editor.Editor;

public class AbrirCommand implements InstruccionCommand {

    private String nombreFichero;

    public AbrirCommand(String nombreFichero) {
        if (nombreFichero == null || nombreFichero.trim().length() == 0)
            throw new IllegalArgumentException("Se necesita el nombre del fichero a abrir");
        this.nombreFichero = nombreFichero;
    }

    @Override
    public void execute(Editor editor){
        editor.abrir(nombreFichero);
    }

}
