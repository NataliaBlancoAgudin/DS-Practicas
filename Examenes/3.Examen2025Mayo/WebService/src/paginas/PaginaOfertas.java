package paginas;

import server.Request;
import server.Response;


public class PaginaOfertas implements PaginaStrategy{

    @Override
    public void send(Response response, Request request) {
        response.send("Las ofertas de esta semana son: Spectrum a 5€. MacBook a 2€. Dell a 3€");
    }

    @Override
    public String getTitle() {
        return "Ofertas";
    }
}
