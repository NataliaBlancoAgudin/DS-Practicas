package decoradores.paginas;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;

public class DecoradorTimer extends DecoradorPagina{

    private long inicio;

    public DecoradorTimer(PaginaStrategy pagina) {
        super(pagina);
    }

    @Override
    public void send(Response response, Request request) {
        inicio = System.nanoTime();
        super.send(response, request);
        long tiempoTrascurrido = System.nanoTime() - inicio;
        response.send("(Timer:" + getTitle() + ") Time=" + tiempoTrascurrido);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }
}
