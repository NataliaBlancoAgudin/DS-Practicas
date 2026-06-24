package decoradores.paginas;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;

public abstract class DecoradorPagina implements PaginaStrategy {
    private PaginaStrategy pagina;

    public DecoradorPagina(PaginaStrategy pagina){
        this.pagina = pagina;
    }

    @Override
    public void send(Response response, Request request) {
        pagina.send(response, request);
    }

    @Override
    public String getTitle() {
        return pagina.getTitle();
    }
}
