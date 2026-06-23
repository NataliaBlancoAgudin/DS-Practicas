package formulario;

import formulario.formularios.Formulario;

import java.io.*;

/* Formulario básico para usar cuando se quieran pedir solo dos valores sobre algo */
public class MiniFormulario {

    public void editar(Formulario formulario) {

        System.out.println("Editando " + formulario.getNombreFormulario());

        System.out.println("Valores actuales:");
        imprimeFormulario(formulario);

        System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
        System.out.print(formulario.getNombreValor1() + " :");
        String texto = getLínea();
        if (texto.length() > 0)
            formulario.setValor1(texto);

        System.out.print(formulario.getNombreValor2() + " :");
        texto = getLínea();
        if (texto.length() > 0)
            formulario.setValor2(texto);

        System.out.println("Valores finales:");
        imprimeFormulario(formulario);
    }

    private void imprimeFormulario(Formulario formulario) {
        System.out.println(formulario.getNombreValor1() + " = " + formulario.getValor1());
        System.out.println(formulario.getNombreValor2() + " = " + formulario.getValor2());
    }

    private String getLínea() {
        do {
            try {
                return consola.readLine();
            } catch (IOException ex) {
                System.out.println("Error de lectura. Inténtelo de nuevo.");
            }
        } while (true);
    }

    BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
}