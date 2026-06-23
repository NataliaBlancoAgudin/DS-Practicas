package observers;

import encuesta.Encuesta;

public class Activador implements Observer {

    private Observer observer;
    private int limite;

    public Activador(Observer observer, int limite) {
        this.observer = observer;
        this.limite = limite;
    }

    @Override
    public void update(Encuesta encuesta) {
        if(limite == 1) {
            observer.update(encuesta);
        }
        else
            limite--;
    }
}
