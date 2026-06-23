package main;

import videoclub.*;

public class Main {

    public static void main(String[] args) {

        Pelicula hotFuzz = new PeliculaNovedad("Hot Fuzz");
        Pelicula toyStory = new PeliculaInfantil("Toy Story");
        Pelicula zombiesParty = new PeliculaNormal("Zombies Party");

        Cliente raul = new Cliente("Raúl");
        raul.addAlquiler(new Alquiler(hotFuzz, 2));
        raul.addAlquiler(new Alquiler(toyStory, 6));
        raul.addAlquiler(new Alquiler(zombiesParty, 8));

        raul.imprimeInforme();
    }
}
