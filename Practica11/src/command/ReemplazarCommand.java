package command;

import editor.Editor;

import java.util.regex.Pattern;

public class ReemplazarCommand implements InstruccionCommand {

    private String valorAReemplazar;
    private String valorReemplazar;

    public ReemplazarCommand(String valorAReemplazar, String valorReemplazar) {
        this.valorAReemplazar = valorAReemplazar;
        this.valorReemplazar = valorReemplazar;
    }

    @Override
    public void execute(Editor editor) {
        editor.reemplazar(valorAReemplazar, valorReemplazar);
    }
}
