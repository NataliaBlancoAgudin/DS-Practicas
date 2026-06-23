package instrucciones;

import model.Document;

public interface InstruccionCommand {
    void execute(Document document);
}
