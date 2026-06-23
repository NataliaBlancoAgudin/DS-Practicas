package command;

import editor.Editor;

import java.util.ArrayList;
import java.util.List;

public class Macro implements InstruccionCommand {

    private List<InstruccionCommand> commands;
    private String nombre;

    public Macro(String nombre){
        this.nombre = nombre;
        commands = new ArrayList<InstruccionCommand>();
    }

    public void add(InstruccionCommand command){
        commands.add(command);
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public void execute(Editor editor){
        for(InstruccionCommand command : commands){
            command.execute(editor);
        }
    }
}
