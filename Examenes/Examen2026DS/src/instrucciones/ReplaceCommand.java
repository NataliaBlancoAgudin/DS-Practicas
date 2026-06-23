package instrucciones;

import model.Document;

import java.util.regex.Pattern;

public class ReplaceCommand implements InstruccionCommand{

    private String palabraAReemplazar, palabraReemplazo;

    public ReplaceCommand(String palabraAReemplazar, String palabraReemplazo) {
        this.palabraAReemplazar = palabraAReemplazar;
        this.palabraReemplazo = palabraReemplazo;
    }

    @Override
    public void execute(Document document) {
        document.setContent(document.getContent().replaceAll(Pattern.quote(palabraAReemplazar), palabraReemplazo));
    }
}
