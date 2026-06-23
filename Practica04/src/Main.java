import campos.*;

/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

public class Main {

    public static void main(String[] args) {
        Formulario formulario = new Formulario();

        formulario.addCampo(new AbstractCampo("Nombre", new CampoTexto()));
        formulario.addCampo(new AbstractCampo("Apellido", new CampoTexto()));
        formulario.addCampo(new AbstractCampo("Teléfono", new CampoNumero()));
        formulario.addCampo(new AbstractCampo("Ciudad", new CampoPredefinido("Santander", "Oviedo", "Cádiz")));
        formulario.addCampo(new AbstractCampo("Código de Producto", new CampoLongitud(4)));
        formulario.addCampo(new AbstractCampo("Código Postal", new CampoAnd(new CampoNumero(), new CampoLongitud(5))));
        formulario.addCampo(new AbstractCampo("Edad", new CampoAnd(new CampoNumero(), new CampoMayor(18))));
        formulario.addCampo(new AbstractCampo("Sueldo", new CampoAnd(new CampoNumero(), new CampoMayor(800), new CampoMenor(1200))));
        formulario.addCampo(new AbstractCampo("Ubicacion", new CampoOr(new CampoPredefinido("Santander", "Oviedo", "Cádiz"), new CampoAnd(new CampoNumero(), new CampoLongitud(5)))));
        formulario.addCampo(new AbstractCampo("Código de Promoción", new CampoOr(new CampoTexto(), new CampoAnd(new CampoNumero(), new CampoLongitud(3)))));

        formulario.pideDatos();
    }
}
