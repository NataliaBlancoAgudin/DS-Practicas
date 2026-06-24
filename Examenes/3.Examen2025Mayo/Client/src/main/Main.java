/*
   NOTA: El código entregado es el mínimo necesario para entender el ejercicio
   y NUNCA debería ser tomado como un ejemplo del tratamiento adecuado de 
   excepciones, asertos y tests. Todo lo anterior, que debería hacerse en un
   programa real, se ha omitido a propósito para simplificar el planteamiento
   del ejercicio.
*/
package main;

import client.TestClient;

// No es necesario modificar este proyecto EXCEPTO para hacer pruebas
// de peticiones al servidor. 
//
public class Main {

    static final int SERVER_PORT = 3000;

    public static void main(String[] args) {

        try {
            TestClient client = new TestClient("localhost", SERVER_PORT);

            // Estas páginas existen
            client.getPage("index.html", "anonimo");
            client.getPage("pedidos", "raul");

            // Por ahora, las siguientes páginas NO EXISTEN y devolveran un error 404
            client.getPage("miCuenta", "cesar");
            client.getPage("miCuenta", "anonimo");

            client.getPage("ofertas", "anonimo");
            client.getPage("ofertas", "aquilino");

            // --------------------------
            // Lo siguiente, poder cerrar el servidor desde un cliente, no es realista.
            // Sin embargo, se hace en este ejercicio para no tener que acordarse durante
            // el examen de tener que matar manualmente el servidor después de CADA ejecución.
            client.shutdownServer();

        } catch (Exception _) {
            System.out.println("Problemas al contactar con el servidor: ¿Seguro que lo has ejecutado primero?");
        }
    }

}
