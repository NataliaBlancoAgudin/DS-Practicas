public class Main {

    public static void main(String[] args) {
        Temperatura[] temperaturas = new Temperatura[100];

        // Toma de datos
        for (int i = 0; i < temperaturas.length / 2; i++){
            temperaturas[i] = new Temperatura();
            temperaturas[i].setCelsius(leeSensorCelsius());
        }

        for (int i = temperaturas.length /2; i < temperaturas.length; i++) {
            temperaturas[i] = new Temperatura();
            temperaturas[i].setFar(leeSensorFar());
        }


        // Cálculo con los datos en Celsius
        double mediaCelsius = 0;
        for (int i = 0; i < temperaturas.length; i++)
            mediaCelsius += temperaturas[i].getCelsius();
        mediaCelsius = mediaCelsius / temperaturas.length;
        System.out.println(mediaCelsius);

        // Cálculo con los datos en Fahrenheit
        double mediaFahrenheit = 0;
        for (int i = 0; i < temperaturas.length; i++)
            mediaFahrenheit += temperaturas[i].getFahrenheit();
        mediaFahrenheit = mediaFahrenheit / temperaturas.length;
        System.out.println(mediaFahrenheit);

        // Otro cálculo con los datos en Fahrenheit
        double varianza = 0;
        for (int i = 0; i < temperaturas.length; i++)
            varianza += Math.pow((temperaturas[i].getFahrenheit()) - mediaFahrenheit, 2);
        varianza = varianza / temperaturas.length;
        System.out.println(varianza);
    }

    // Leer la temperatura de un sensor
    public static double leeSensorCelsius() {
        return Math.random() * 30;
    }

    public static double leeSensorFar() {
        return Math.random() * 30;
    }


}