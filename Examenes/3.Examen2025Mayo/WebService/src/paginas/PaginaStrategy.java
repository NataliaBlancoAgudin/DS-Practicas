package paginas;

import server.Request;
import server.Response;

public interface PaginaStrategy {
    void send(Response response, Request request);
    String getTitle();
}
