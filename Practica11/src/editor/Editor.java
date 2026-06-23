package editor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Editor {

    private static StringBuilder texto;

    public Editor() {
        texto = new StringBuilder("");
    }

    public void abrir(String nombreFichero){
        try {
            texto = readFile(nombreFichero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrar(){
        int indexOfLastWord = texto.toString().trim().lastIndexOf(" ");
        if (indexOfLastWord == -1)
            texto = new StringBuilder("");
        else
            texto.setLength(indexOfLastWord + 1);
    }

    public void insertar(String[] listaInsercion){
        for(String s : listaInsercion) {
            texto.append(s + " ");
        }
    }

    public void reemplazar(String valorAReemplazar, String valorReemplazar){
        texto = new StringBuilder(texto.toString().replaceAll(Pattern.quote(valorAReemplazar), valorReemplazar));
    }

    /**
     * Metodo para leer un archivo (pasandole como parametro el nombre) y devolver un StringBuilder
     *
     * @param filename Nombre del archivo
     * @return StringBuilder
     * @throws IOException
     */
    private StringBuilder readFile(String filename) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("files/" + filename));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = input.readLine()) != null) {
            result.append(line);
        }
        input.close();
        return result;
    }

    public StringBuilder getTexto() {
        return texto;
    }
}
