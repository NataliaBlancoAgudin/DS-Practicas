/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import editor.*;
import figuras.circulo.HerramientaCirculo;
import figuras.cuadrado.HerramientaCuadrado;
import figuras.triangulo.HerramientaTriangulo;

public class Main {

    public static void main(String[] args) throws IOException {
        Editor editor = new Editor();
        editor.registrarHerramienta("circulo", new HerramientaCirculo(editor));
        editor.registrarHerramienta("cuadrado", new HerramientaCuadrado(editor));
        editor.registrarHerramienta("triangulo", new HerramientaTriangulo(editor));
        editor.run();
    }

}
