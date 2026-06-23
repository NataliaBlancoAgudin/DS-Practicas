package editor;

import figuras.Figura;

import java.util.*;

public class Dibujo {

	// Lista de Figuras de nuestro dibujo
	private List<Figura> figuras = new ArrayList<Figura>();

	/**
	 * Añadimos una nueva figura a nuestro dibujo
	 * @param figura Figura para añadir a nuestra lista de figuras
	 */
	public void addFigura(Figura figura) {
		figuras.add(figura);
	}

	/**
	 * Dibujamos todas las figuras que contenga el Dibujo
	 */
	public void dibujar() {
		for (Figura figura : figuras) {
			figura.dibujar();
		}
	}

	/**
	 * Devuelve la figura que este contenida en las coordenadas x e y
	 *
	 * @param posX Coordenada x del punto que queremos seleccionar
	 * @param posY Coordenada y del punto que queremos seleccionar
	 * @return Figura que esta contenida en dichas coordenadas
	 */
	public Figura getFigura(int posX, int posY) {
		for (Figura figura : figuras) {
			if(figura.contiene(posX, posY)) {
				return figura;
			}
		}
		return null;
	}
}
