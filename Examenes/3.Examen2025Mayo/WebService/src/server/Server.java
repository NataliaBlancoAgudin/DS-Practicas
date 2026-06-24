package server;

import paginas.PaginaStrategy;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private ServerSocket serverSocket;
    private int port;
    private PaginaStrategy paginaPorDefecto;
    private Map<String, PaginaStrategy> paginas;

    public Server(int port) {
        this.port = port;
        this.paginas = new HashMap<>();
    }

    public void setPaginaPorDefecto(PaginaStrategy paginaPorDefecto) {
        this.paginaPorDefecto = paginaPorDefecto;
    }

    public void addPagina(String url, PaginaStrategy strategy) {
        paginas.put(url, strategy);
    }

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Esperando peticiones en el puerto " + port + "...");

        String command;
        do {
            Socket clientConnection = serverSocket.accept(); // Esperar una petición de un cliente

            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
            command = fromClient.readLine();

            if (command.equals("GET")) {
                Request request = parseRequest(fromClient);
                Response response = new Response(clientConnection);
                sendPage(request, response);
            }

            clientConnection.close();

        } while (!command.equals("SHUTDOWN"));

        System.err.println("Servidor apagado");
    }

    /**
     * Crea un objeto con los parámetros de la petición.
     * Para simplificar, no se hace validación de la entrada.
     * NO ES OBJETIVO de este ejercicio mejorar ni generalizar esta parte del protocolo.
     */
    private Request parseRequest(BufferedReader fromClient) throws IOException {
        String pageURL = fromClient.readLine();
        String user = fromClient.readLine();
        String clientIP = fromClient.readLine();

        return new Request(pageURL, user, clientIP);
    }

    /**
     * Devuelve la página que ha pedido el cliente.
     */
    private void sendPage(Request request, Response response) {

        System.out.println("[Log Server] Petición recibida: " + request.toString());

        PaginaStrategy strategy = paginas.getOrDefault(request.getPageURL(), paginaPorDefecto);

        strategy.send(response, request);

    }

}
