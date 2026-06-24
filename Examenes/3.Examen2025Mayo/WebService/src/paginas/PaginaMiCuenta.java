package paginas;

import server.Request;
import server.Response;
import util.UserAuthentication;

public class PaginaMiCuenta implements PaginaStrategy{

    @Override
    public void send(Response response, Request request) {
        response.send(" Su usuario es: " + request.getUser());
        response.send(" Su contraseña es: 1111");
    }

    @Override
    public String getTitle() {
        return "MiCuenta";
    }
}
