package formulario;

import formulario.formularios.FormularioFoto;
import formulario.formularios.FormularioMonumento;
import formulario.formularios.FormularioRestaurante;
import google.maps.*;
import model.foto.Foto;
import model.monumento.Monumento;
import model.restaurante.Restaurante;

public class Main {

    public static void main(String[] args) {

        Monumento monumento = new Monumento("Coliseo", "Vespasiano", "Avenida del Coliseo 1. Roma");
        Restaurante restaurante = new Restaurante("Mario", "Via della Dataria. Roma", "555 123 457");
        Foto foto = new Foto("Raúl", "Un perro mordiendo a un turista", new Coordenadas(40, 40));

        MiniFormulario formulario = new MiniFormulario();

        FormularioMonumento formularioMonumento = new FormularioMonumento(monumento);
        formulario.editar(formularioMonumento);
        System.out.println();

        // Tarea 1. Editar también restaurante. Que se puedan editar el nombre y la dirección del mismo.
        FormularioRestaurante formularioRestaurante = new FormularioRestaurante(restaurante);
        formulario.editar(formularioRestaurante);
        System.out.println();

        // Tarea 2. Editar también foto. Que se puedan editar el usuario y la descripción de la misma.
        FormularioFoto formularioFoto = new FormularioFoto(foto);
        formulario.editar(formularioFoto);

        // NOTA: Para simplificar, suponer que siempre se van a pedir sólo dos campos en todo formulario
    }

}
