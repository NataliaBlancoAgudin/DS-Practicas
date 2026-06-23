package observers;

import encuesta.Encuesta;

public class BaseDatos implements Observer {

    @Override
    public void update(Encuesta encuesta) {
        System.out.println("Aquí se guardarán los datos en disco/BD.");
    }
}
