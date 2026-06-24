/*
   NOTA: El código entregado es el mínimo necesario para entender el ejercicio
   y NUNCA debería ser tomado como un ejemplo del tratamiento adecuado de 
   excepciones, asertos y tests. Todo lo anterior, que debería hacerse en un
   programa real, se ha omitido a propósito para simplificar el planteamiento
   del ejercicio.
*/

package main;

import decoradores.control.DecoradorControlFinDeSemana;
import decoradores.control.DecoradorControlUsuario;
import decoradores.paginas.DecoradorCounter;
import decoradores.paginas.DecoradorTimer;
import paginas.*;
import paginas.noValidas.PaginaNoValida401;
import paginas.noValidas.PaginaNoValida404;
import paginas.noValidas.PaginaNoValidaFinDeSemana;
import server.*;

public class Main {
    static final int SERVER_PORT = 3000;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
//        runOriginal();
//        runRedesigned();
//        run1();
//        run2();
//        run3();
        run4();
    }

    private void runOriginal() throws Exception {
        System.out.println("Ejecutando el servidor original...");
        Server server = new Server(SERVER_PORT);
        server.startServer();
    }

    private void runRedesigned() throws Exception {
        System.out.println("Ejecutando el servidor tras el rediseño...");
        Server server = new Server(SERVER_PORT);
        String nombreEmpresa = "Computers'R Us";
        server.setPaginaPorDefecto(new PaginaNoValida404(nombreEmpresa));
        PaginaStrategy inicio = new PaginaInicio("Computers'R Us");
        PaginaPedidos pedidos = new PaginaPedidos();
        server.addPagina("index.html", inicio);
        server.addPagina("pedidos", pedidos);
        server.startServer();
    }

    private void run1() throws Exception {
        System.out.println("Ejecutando el servidor con la ampliación 1...");
        Server server = new Server(SERVER_PORT);
        String nombreEmpresa = "Computers'R Us";
        server.setPaginaPorDefecto(new PaginaNoValida404(nombreEmpresa));
        PaginaStrategy inicio = new PaginaInicio(nombreEmpresa);
        PaginaPedidos pedidos = new PaginaPedidos();
        PaginaMiCuenta mic = new PaginaMiCuenta();
        PaginaOfertas ofertas = new PaginaOfertas();
        server.addPagina("index.html", inicio);
        server.addPagina("pedidos", pedidos);
        server.addPagina("miCuenta", mic);
        server.addPagina("ofertas", ofertas);
        server.startServer();
    }

    private void run2() throws Exception {
        System.out.println("Ejecutando el servidor con la ampliación 2...");
        Server server = new Server(SERVER_PORT);
        String nombreEmpresa = "Computers'R Us";
        server.setPaginaPorDefecto(new PaginaNoValida404(nombreEmpresa));
        server.addPagina("index.html", new DecoradorCounter(new DecoradorTimer(new PaginaInicio(nombreEmpresa))));
        server.addPagina("pedidos", new PaginaPedidos());
        server.addPagina("miCuenta", new DecoradorTimer(new PaginaMiCuenta()));
        server.addPagina("ofertas", new DecoradorCounter(new PaginaOfertas()));
        server.startServer();
    }

    private void run3() throws Exception {
        System.out.println("Ejecutando el servidor con la ampliación 3...");
        Server server = new Server(SERVER_PORT);
        String nombreEmpresa = "Computers'R Us";
        server.setPaginaPorDefecto(new PaginaNoValida404(nombreEmpresa));
        server.addPagina("index.html", new PaginaInicio(nombreEmpresa));
        server.addPagina("pedidos", new DecoradorControlUsuario(new PaginaPedidos(), new PaginaNoValida404(nombreEmpresa)));
        server.addPagina("miCuenta", new DecoradorControlUsuario(new PaginaMiCuenta(), new PaginaNoValida401()));
        server.addPagina("ofertas", new DecoradorControlFinDeSemana(new PaginaOfertas(), new PaginaNoValidaFinDeSemana()));
        server.startServer();
    }

    private void run4() throws Exception {
        System.out.println("Ejecutando el servidor con la ampliación 4...");
        Server server = new Server(SERVER_PORT);
        String nombreEmpresa = "Computers'R Us";
        server.setPaginaPorDefecto(new PaginaNoValida404(nombreEmpresa));
        server.addPagina("index.html", new PaginaInicio(nombreEmpresa));
        server.addPagina("ofertas", new DecoradorControlFinDeSemana(new PaginaOfertas(), new PaginaNoValidaFinDeSemana()));

        server.addPagina("pedidos",
                new DecoradorTimer(
                        new DecoradorControlUsuario(
                                new DecoradorTimer(
                                        new PaginaPedidos()),
                                new PaginaNoValida404(nombreEmpresa))));
        server.addPagina("miCuenta",
                new DecoradorControlUsuario(
                        new DecoradorCounter(
                                new PaginaMiCuenta()),
                        new DecoradorCounter(
                                new PaginaNoValida401())));
        server.startServer();
    }
}
