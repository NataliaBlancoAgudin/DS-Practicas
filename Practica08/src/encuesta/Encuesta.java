package encuesta;

import observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Encuesta {

    private int si, no;
    private String pregunta;
    private List<Observer> observerEncuestas;

    public Encuesta(String pregunta) {
        this.pregunta = pregunta;
        this.observerEncuestas = new ArrayList<Observer>();
    }

    public String getPregunta() {
        return pregunta;
    }

    public int getVotosSi() {
        return si;
    }

    public int getVotosNo() {
        return no;
    }

    public void incrementaSi() {
        si++;
        actualizar();
    }

    public void incrementaNo() {
        no++;
        actualizar();
    }

    public void addObserver(Observer o) {
        observerEncuestas.add(o);
    }

    // Parte de representar los datos
    private void actualizar(){
        for(Observer o : observerEncuestas){
            o.update(this);
        }
    }
}
