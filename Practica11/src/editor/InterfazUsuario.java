package editor;

import command.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InterfazUsuario {

    private Editor editor;
    private static BufferedReader in;
    private static ActionManager manager;

    public InterfazUsuario() {
        in = new BufferedReader(new InputStreamReader(System.in));
        editor = new Editor();
        manager = new ActionManager(editor);
    }

    public static void mostrarMenu() {
        System.out.println("Acciones");
        System.out.println("--------");
        System.out.println("abre <fichero>");
        System.out.println("inserta <texto>\t\t// inserta las palabras al final del texto");
        System.out.println("borra\t\t\t// borra la última palabra");
        System.out.println("reemplaza <a> <b>\t// reemplaza la cadena <a> por la <b> en todo el texto");
        System.out.println("salir");
        System.out.println();
        System.out.println("Tareas");
        System.out.println("------");
        System.out.println("graba <macro>\t\t// comienza la grabación de una macro");
        System.out.println("para\t\t\t// finaliza la grabación");
        System.out.println("ejecuta <macro>\t\t// ejecuta la macro cuyo nombre se indique");
        System.out.println();
    }

    public void run() throws IOException {
        mostrarMenu();
        do {
            System.out.print("> ");

            String[] line = in.readLine().split(" ");

            // No se comprueba que el número de palabras sea el adecuado

            if (line[0].equals("salir"))
                return;

            if (line[0].equals("abre")) {
                InstruccionCommand abre = new AbrirCommand(line[1]);
                manager.execute(abre);
            } else if (line[0].startsWith("ins")) {
                String[] listaInsercion = Arrays.copyOfRange(line, 1, line.length);
                InstruccionCommand inserta = new InsertaCommand(listaInsercion);
                manager.execute(inserta);
            } else if (line[0].startsWith("borr")) {
                InstruccionCommand borrar = new BorrarCommand();
                manager.execute(borrar);
            } else if (line[0].startsWith("reem")) {
                InstruccionCommand reemplazar = new ReemplazarCommand(line[1], line[2]);
                manager.execute(reemplazar);
            } else if (line[0].startsWith("graba")) {
                manager.grabar(line[1]);
            } else if (line[0].startsWith("para")) {
                manager.parar();
            } else if (line[0].startsWith("ejecuta")) {
                manager.ejecutarGrabacion(line[1]);
            } else {
                System.out.println("Instrucción desconocida");
            }

            System.out.println(editor.getTexto());

        } while (true);
    }
}
