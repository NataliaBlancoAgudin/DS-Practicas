package platform.playstation;

import platform.Image2D;
import platform.Platform;

import java.awt.*;

public class PlaystationPlatform implements Platform {

    private Playstation5API playstation5API = new Playstation5API();

    @Override
    public Image2D cargarImagen(String nombre) {
        return playstation5API.loadGraphics(nombre);
    }

    @Override
    public void pintar(int x, int y, Image2D imagen) {
        playstation5API.render(x, y, imagen);
    }

    @Override
    public Point pinchar() {
        return playstation5API.getJoystick();
    }
}
