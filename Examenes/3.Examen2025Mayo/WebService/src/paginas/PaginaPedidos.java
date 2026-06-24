package paginas;

import server.Request;
import server.Response;

public class PaginaPedidos implements PaginaStrategy {

    @Override
    public void send(Response response, Request request) {
        response.send("Estos son los pedidos realizados por -> " + request.getUser());
        response.send("     - 5/19 Dell Inspiron");
        response.send("     - 3/19 Monitor Acer");
    }

    @Override
    public String getTitle() {
        return "Pedidos";
    }
}
