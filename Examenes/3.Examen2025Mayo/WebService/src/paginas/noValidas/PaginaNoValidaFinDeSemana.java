package paginas.noValidas;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;

public class PaginaNoValidaFinDeSemana implements PaginaStrategy {

    @Override
    public void send(Response response, Request request) {
        response.send("Espere al fin de semana para ver nuestras ofertas.");
    }

    @Override
    public String getTitle() {
        return "";
    }
}
