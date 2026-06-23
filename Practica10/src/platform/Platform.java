package platform;

import java.awt.*;

public interface Platform {
    Image2D cargarImagen(String nombre);
    void pintar(int x, int y, Image2D imagen);
    Point pinchar();
}
