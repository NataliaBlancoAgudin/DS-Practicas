package game;

import java.awt.Point;

import platform.*;
import platform.android.*;
import platform.playstation.*;
import platform.windows.*;

/* Esta clase/paquete sería el código del videojuego, el cual se quiere reutilizar
 * en las distintas plataformas
 */


public class BallGame {

    private Platform platform;

    public BallGame(Platform platform) {
        this.platform = platform;
    }

    public void start() {
        Image2D image = loadImage("Bola.jpg");

        // Lógica principal del juego
        for (int i = 0; i < 10; i++) {
            Point point = getPosition();
            // Comprobar colisiones...
            // Imprimir marcador...
            // Otra lógica del juego...
            drawBall(image, point);
        }
    }

    private Image2D loadImage(String file) {
        return platform.cargarImagen(file);
    }

    private void drawBall(Image2D image, Point point) {
        platform.pintar(point.x, point.y,image);
    }

    private Point getPosition() {
       return platform.pinchar();
    }
}
