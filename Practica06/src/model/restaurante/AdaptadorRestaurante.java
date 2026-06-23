package model.restaurante;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;

// Clase Adapter -> Adapta los restaurantes a la interfaz Marcador que tenemos
public class AdaptadorRestaurante implements Marcador {

    private Restaurante restaurante;
    private Navegador navegador;

    public AdaptadorRestaurante(Restaurante restaurante, Navegador navegador) {
        this.restaurante = restaurante;
        this.navegador = navegador;
    }

    @Override
    public Coordenadas getCoordenadas() {
        return navegador.getCoordenadas(restaurante.getDirección());
    }

    @Override
    public String getTooltipInfo() {
        return restaurante.getNombre() + " - " + restaurante.getTeléfono();
    }

    @Override
    public void abrir() {
        System.out.println("Pulsado en Restaurante: Llamar al restaurante");
        restaurante.llamar();
    }
}
