package decoradores.paginas;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;

public class DecoradorCounter extends DecoradorPagina {

    private int counter = 0;

    public DecoradorCounter(PaginaStrategy pagina) {
        super(pagina);
    }

    @Override
    public void send(Response response, Request request) {
        super.send(response, request);
        counter++;
        response.send("(Counter:" + getTitle() + ") Value = " + counter);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }
}
