package paginas.noValidas;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;

public class PaginaNoValida404 implements PaginaStrategy {

    private String nombrePagina;

    public PaginaNoValida404(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }

    @Override
    public void send(Response response, Request request) {
        response.send("Error 404. Esta página no existe en " + nombrePagina);
    }

    @Override
    public String getTitle() {
        return "No Valida";
    }
}
