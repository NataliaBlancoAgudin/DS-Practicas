package model.monumento;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;

// Clase Adapter -> Adapta los monumentos a la interfaz Marcador que tenemos
public class AdaptadorMonumento implements Marcador {

    private Monumento monumento;
    private Navegador navegador;

    public AdaptadorMonumento(Monumento monumento, Navegador navegador) {
        this.monumento = monumento;
        this.navegador = navegador;
    }

    @Override
    public Coordenadas getCoordenadas() {
        return navegador.getCoordenadas(monumento.getDirección());
    }

    @Override
    public String getTooltipInfo() {
        return monumento.getNombre() + " - " + monumento.getAutor();
    }

    @Override
    public void abrir() {
        System.out.println("Pulsado en Monumento: Navegar hasta " + monumento.getNombre() + " con el GPS");
        navegador.navegarHasta(monumento.getDirección());
    }
}
