package observers;

import encuesta.Encuesta;

public class Intervalo implements Observer {

    private Observer observer;
    private int contador;
    private int intervalo;

    public Intervalo(Observer observer,int intervalo) {
        this.observer = observer;
        this.contador = this.intervalo = intervalo;
    }

    @Override
    public void update(Encuesta encuesta) {
        if(contador == intervalo) {
            observer.update(encuesta);
            contador = 1;
        }
        else
            contador++;
    }
}
