/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import decoradores.Decorador;
import decoradores.Encripador;
import decoradores.EspaciosRepetidos;
import decoradores.Normalizador;
import fileSystem.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileSystem fs = new FileSystem();
        System.out.println("Hola");

        Salida fichero = new Fichero("files/copiaRefactoriado.txt");
        fs.procesarFichero("files/privado.txt", fichero);
        System.out.println();

        Salida internet = new Internet("156.17.11.196");
        fs.procesarFichero("files/privado.txt", internet);
        System.out.println();

        Salida bluetooth = new Bluetooth("Galaxy de Raúl");
        fs.procesarFichero("files/privado.txt", bluetooth);
        System.out.println();

        System.out.println("=== PRIMER REQUISITO: NORMALIZAR LOS SALTOS DE LÍNEA");
        Salida fichero2 = new Fichero("files/copiaRefactoriadoPrimerRequisito.txt");
        Decorador normalizador = new Normalizador(fichero2);
        fs.procesarFichero("files/privado.txt", normalizador);

        System.out.println("=== SEGUNDO REQUISITO: CIFRADO CESAR");
        Salida internet2 = new Internet("156.17.11.196");
        Decorador encripador = new Encripador(internet2);
        fs.procesarFichero("files/privado.txt", encripador);

        System.out.println("=== TERCER REQUISITO: ESPACIOS REPETIDOS");
        Salida bluetooth2 = new Bluetooth("Galaxy de Raúl");
        Decorador espaciosRepetidos = new EspaciosRepetidos(bluetooth2);
        fs.procesarFichero("files/privado.txt", espaciosRepetidos);

        System.out.println("=== CUARTO REQUISITO: NORMALIZAR LOS SALTOS DE LÍNEA Y ENCRIPTAR");
        Salida fichero3 = new Fichero("files/copiaRefactoriadoCuartoRequisito.txt");
        Decorador normalizador2 = new Normalizador(fichero3);
        Decorador encripador2 = new Encripador(normalizador2);
        fs.procesarFichero("files/privado.txt", encripador2);
    }
}
