package editor;

import model.Document;
import modos.Modo;
import modos.ModoDefine;
import modos.ModoNormal;
import modos.ModoRecord;

import java.io.*;
import java.util.*;

public class Editor {
    private BufferedReader in;
    private boolean echo = false;
    private Document document;

    private Modo modoActual;

    private ActionManager actionManager;

    public Editor() {
        in = new BufferedReader(new InputStreamReader(System.in));
        document = new Document();
        modoActual = new ModoNormal(this, document);
        actionManager = new ActionManager(document);
    }

    public Editor(Reader input, boolean echo) {
        in = new BufferedReader(input);
        document = new Document();
        modoActual = new ModoNormal(this, document);
        this.echo = echo;
        actionManager = new ActionManager(document);
    }

    public void run() throws IOException {
        System.out.println("====== EDITOR DE TEXTO ======");

        do {
            System.out.print("> ");
            String line = in.readLine();
            if (line == null)
                break;
            if (echo)
                System.out.println(line);
            
            String[] parts = line.split("\\s+");
            if (parts[0].equals("exit")) break;

            switch (parts[0]) {
                case "open" -> {
                    modoActual.open(parts[1]);
                }
                case "insert" -> {
                    String text = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length));
                    modoActual.insert(text);
                }
                case "delete" -> {
                    modoActual.delete();
                }
                case "replace" -> {
                    modoActual.replace(parts[1], parts[2]);
                }
                case "record" -> {
                    if(modoActual.getName() == "Record")
                        System.out.println("A macro is already being recorded");
                    else{
                        modoActual = new ModoRecord(this, document);
                        actionManager.grabar(parts[1]);
                    }
                }
                case "define" -> {
                    if(modoActual.getName() == "Define")
                        System.out.println("A macro is already being recorded");
                    else{
                        modoActual = new ModoDefine(this);
                        actionManager.grabar(parts[1]);
                    }
                }
                case "stop" -> {
                    modoActual.stop();
                }
                case "play" -> {
                    modoActual.play(parts[1]);
                }
                default -> System.err.println("Unknown command");
            }
            System.out.println(document.getContent() + "\n");
        } while (true);
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setModoActual(Modo modoActual) {
        this.modoActual = modoActual;
    }
}