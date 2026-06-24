package instrucciones;

import model.Document;

public class DeleteCommand implements InstruccionCommand{

    @Override
    public void execute(Document document) {
        int lastSpace = document.getContent().trim().lastIndexOf(" ");
        if (lastSpace == -1)
            document.setContent("");
        else
            document.setContent(document.getContent().substring(0, lastSpace + 1));
    }
}
