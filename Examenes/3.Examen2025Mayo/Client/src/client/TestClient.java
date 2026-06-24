/*
   NOTA: El código entregado es el mínimo necesario para entender el ejercicio
   y NUNCA debería ser tomado como un ejemplo del tratamiento adecuado de 
   excepciones, asertos y tests. Todo lo anterior, que debería hacerse en un
   programa real, se ha omitido a propósito para simplificar el planteamiento
   del ejercicio.
*/
package client;

import java.net.*;
import java.io.*;

public class TestClient {
    
    private String serverIP;
    private int port;

    public TestClient(String serverIP, int port) {
        this.serverIP = serverIP;
        this.port = port;
    }

    /* ------------------------------------------------------------------
     * $ Pedir una página al servidor
     */
    public void getPage(String url, String user) throws IOException {
        try (
            // Conectar al servidor
            Socket serverConnection = new Socket(serverIP, port);
            PrintWriter toServer = new PrintWriter(serverConnection.getOutputStream(), true);
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(serverConnection.getInputStream()))
        ) {
            // Enviar petición: nombre de la página, usuario que la pide e IP
            toServer.println("GET");
            toServer.println(url);
            toServer.println(user);
            toServer.println(java.net.InetAddress.getLocalHost()); // Dirección IP del cliente

            // Esperar respuesta con la página solicitada
            String line;
            System.out.println("\n[Log Cliente] Recibida página: " + url);
            while ((line = fromServer.readLine()) != null)
                System.out.println("\t| " + line);
        }
    }

    /* ------------------------------------------------------------------
     * $ Apagar el servidor
     */
    public void shutdownServer() throws IOException {
        try (Socket serverConnection = new Socket(serverIP, port);
             PrintWriter toServer = new PrintWriter(serverConnection.getOutputStream(), true)) {
            toServer.println("SHUTDOWN");
        }
    }
}
