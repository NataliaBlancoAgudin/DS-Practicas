package platform.windows;

import platform.Image2D;
import platform.Platform;

import java.awt.*;

public class WindowsPlatform implements Platform {

    private WindowsAPI windowsAPI = new WindowsAPI();

    @Override
    public Image2D cargarImagen(String nombre) {
        return windowsAPI.loadFile(nombre);
    }

    @Override
    public void pintar(int x, int y, Image2D imagen) {
        windowsAPI.paint(x, y, imagen);
    }

    @Override
    public Point pinchar() {
        return windowsAPI.getMouseClick();
    }
}
