package decoradores.control;

import paginas.PaginaStrategy;
import server.Request;
import server.Response;
import util.DateUtil;

public class DecoradorControlFinDeSemana extends DecoradorControl{

    private DateUtil dateUtil;

    public DecoradorControlFinDeSemana(PaginaStrategy pagina, PaginaStrategy paginaError) {
        super(pagina, paginaError);
        this.dateUtil = new DateUtil();
    }

    @Override
    public void send(Response response, Request request) {
        if(dateUtil.isWeekendToday())
            paginaValida.send(response, request);
        else
            paginaError.send(response, request);
    }
}
