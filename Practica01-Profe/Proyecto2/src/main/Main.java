package main;

import videoclub.*;

public class Main {

    public static void main(String[] args) {

        Pelicula hotFuzz = new Pelicula("Hot Fuzz", Pelicula.NOVEDAD);
        Pelicula toyStory = new Pelicula("Toy Story", Pelicula.INFANTIL);
        Pelicula zombiesParty = new Pelicula("Zombies Party", Pelicula.NORMAL);

        Cliente raul = new Cliente("Raúl");
        raul.addAlquiler(new Alquiler(hotFuzz, 2));
        raul.addAlquiler(new Alquiler(toyStory, 6));
        raul.addAlquiler(new Alquiler(zombiesParty, 8));

        raul.imprimeInforme();
    }
}
