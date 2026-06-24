package paginas;

import server.Request;
import server.Response;

public class PaginaInicio implements PaginaStrategy {

    private String nombrePagina;

    public PaginaInicio(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }

    @Override
    public void send(Response response, Request request) {
        response.send("Bienvenido a " + nombrePagina);
    }

    @Override
    public String getTitle() {
        return "Indice";
    }
}
