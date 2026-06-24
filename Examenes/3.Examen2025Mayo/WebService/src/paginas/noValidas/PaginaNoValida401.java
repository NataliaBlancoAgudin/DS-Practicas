package paginas.noValidas;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;

public class PaginaNoValida401 implements PaginaStrategy {

    @Override
    public void send(Response response, Request request) {
        response.send("Error 401. El usuario no está autorizado: " + request.getUser());
    }

    @Override
    public String getTitle() {
        return "No Valida";
    }
}
