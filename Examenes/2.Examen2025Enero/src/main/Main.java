package main;

import gui.Window;
import model.Document;

class Main {
    public static void main(String[] args) {

        var document = new Document("Don Quijote",
                """
                En un lugar de la mancha de
                cuyo nombre no quiero acordarme
                no ha mucho tiempo que vivía un
                hidalgo de lanza en astillero
                adarga antigua, rocín flaco
                y galgo corredor.
                """);

        var window = new Window(document);
        window.setVisible(true);
    }
}
