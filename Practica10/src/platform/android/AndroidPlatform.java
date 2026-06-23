package platform.android;

import platform.Image2D;
import platform.Platform;

import java.awt.*;

public class AndroidPlatform implements Platform {

    private AndroidAPI androidAPI = new AndroidAPI();

    @Override
    public Image2D cargarImagen(String nombre) {
        return androidAPI.loadResource(nombre);
    }

    @Override
    public void pintar(int x, int y, Image2D imagen) {
        androidAPI.draw(x, y, imagen);
    }

    @Override
    public Point pinchar() {
        return androidAPI.getTouch();
    }
}
