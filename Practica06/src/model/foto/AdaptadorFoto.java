package model.foto;

import google.maps.Coordenadas;
import google.maps.Marcador;

// Clase Adapter -> Adapta las fotos a la interfaz Marcador que tenemos
public class AdaptadorFoto implements Marcador {

    private Foto foto;

    public AdaptadorFoto(Foto foto) {
        this.foto = foto;
    }

    @Override
    public Coordenadas getCoordenadas() {
        return foto.getCoordenadas();
    }

    @Override
    public String getTooltipInfo() {
        return foto.getUsuario() + " - " + foto.getDescripción();
    }

    @Override
    public void abrir() {
        System.out.println("Pulsando Foto: Bajarse foto");
        foto.descargar();
    }
}
