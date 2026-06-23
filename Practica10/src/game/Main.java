/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package game;

import platform.Platform;
import platform.android.AndroidPlatform;
import platform.playstation.PlaystationPlatform;
import platform.windows.WindowsPlatform;

// JUEGO EN ANDROID
public class Main {
    public static void main(String[] args) {
        Platform android = new AndroidPlatform();
        BallGame game = new BallGame(android);
        game.start();
    }
}

// JUEGO EN PLAYSTATION
class Main2 {
    public static void main(String[] args) {
        Platform playstation = new PlaystationPlatform();
        BallGame game = new BallGame(playstation);
        game.start();
    }
}

// JUEGO EN WINDOWS
class Main3 {
    public static void main(String[] args) {
        Platform windows = new WindowsPlatform();
        BallGame game = new BallGame(windows);
        game.start();
    }
}
