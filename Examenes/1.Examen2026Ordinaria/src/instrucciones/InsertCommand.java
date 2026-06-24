package instrucciones;

import model.Document;

public class InsertCommand implements InstruccionCommand{

    private String text;

    public InsertCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(Document document) {
        document.setContent(document.getContent() + text + " ");
    }
}
