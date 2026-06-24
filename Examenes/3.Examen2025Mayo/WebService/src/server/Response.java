package server;

import java.io.*;
import java.net.Socket;

public class Response{

    private PrintWriter out;

    public Response(Socket connection) throws IOException {
        out = new PrintWriter(connection.getOutputStream(), true);
    }

    public void send(String text) {
        out.println(text);
    }
}
