package observers;

import encuesta.Encuesta;

public class LineaEstado implements Observer {

    @Override
    public void update(Encuesta encuesta) {
        System.out.println("Nº de votos SI = " + encuesta.getVotosSi() + ". Nº de votos NO = " + encuesta.getVotosNo());
    }
}
