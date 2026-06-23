package observers;

import encuesta.Encuesta;

public class GraficoBarras implements Observer {

    @Override
    public void update(Encuesta encuesta) {
        System.out.println("Aquí se dibujaría el gráfico de barras.");
    }
}
