package observers;

import encuesta.Encuesta;

public class GraficoCircular implements Observer {

    @Override
    public void update(Encuesta encuesta) {
        System.out.println("Aquí se dibujaría el gráfico circular.");
    }
}
