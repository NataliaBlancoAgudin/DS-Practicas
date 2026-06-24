package decoradores.control;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;
import util.UserAuthentication;

public class DecoradorControlUsuario extends DecoradorControl{

    private UserAuthentication user;

    public DecoradorControlUsuario(PaginaStrategy paginaValida, PaginaStrategy paginaError) {
        super(paginaValida, paginaError);
        this.user = new UserAuthentication();
    }

    @Override
    public void send(Response response, Request request) {
        if(user.isValid(request.getUser()))
            paginaValida.send(response, request);
        else {
            paginaError.send(response, request);
        }
    }
}
