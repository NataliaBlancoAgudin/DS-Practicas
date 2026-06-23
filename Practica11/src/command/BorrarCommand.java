package command;

import editor.Editor;

public class BorrarCommand implements InstruccionCommand {

    @Override
    public void execute(Editor editor){
        editor.borrar();
    }
}
