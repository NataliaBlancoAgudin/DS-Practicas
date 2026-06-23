# Práctica 1
## Proyecto 2 - Videoclub
Lo primero que se ha observado es que la clase `Cliente` estaba repleta de funcionalidades que no le correspondían a ella
calcular: el calculo del alquiler y el calculo de puntos:
```java
public class Cliente {
    //...

    public void imprimeInforme() {
        double totalPrecio = 0;
        int totalPuntos = 0;
        System.out.println("Informe de los alquileres de: " + getNombre());

        for (Alquiler alquiler : alquileres) {

            // 1) Calcula el importe de cada alquiler
            double precioAlquiler = 0;
            switch (alquiler.getPelicula().getCategoria()) {
                case Pelicula.NOVEDAD:
                    precioAlquiler += alquiler.getDias() * 3;
                    break;
                case Pelicula.NORMAL:
                    precioAlquiler += 2;
                    if (alquiler.getDias() > 2)
                        precioAlquiler += (alquiler.getDias() - 2) * 1.5;
                    break;
                case Pelicula.INFANTIL:
                    precioAlquiler += 1.5;
                    if (alquiler.getDias() > 3)
                        precioAlquiler += (alquiler.getDias() - 3) * 1.5;
                    break;
            }

            // 2) Cada alquiler da 1 punto. Punto extra para novedades alquiladas 2 o m�s d�as
            int puntosAlquiler = 1;
            if ((alquiler.getPelicula().getCategoria() == Pelicula.NOVEDAD) && alquiler.getDias() > 1)
                puntosAlquiler = 2;

            // 3) Acumula los totales
            totalPrecio += precioAlquiler;
            totalPuntos += puntosAlquiler;

            // 4) Muestra el importe de este alquiler
            System.out.println("\t- " + alquiler.getPelicula().getTitulo() + "\t" + precioAlquiler + "€");

        }

        System.out.println("La deuda es de " + totalPrecio + "€.\n");
        System.out.println("Ha obtenido " + totalPuntos + " puntos en tu tarjeta.");
    }
}
```

Lo primero que hemos hecho es trasladar esa funcionalidad del cálculo del alquier y de los puntos a la clase `Alquiler`
(que al final es la que tiene sentido que lleve dichos calculos porque es su responsabildiad):

```java
public class Alquiler {
    //...

    public double getPrecioAlquiler(Alquiler alquiler) {
        double precioAlquiler = 0;
        switch (alquiler.getPelicula().getCategoria()) {
            case Pelicula.NOVEDAD:
                precioAlquiler += alquiler.getDias() * 3;
                break;
            case Pelicula.NORMAL:
                precioAlquiler += 2;
                if (alquiler.getDias() > 2)
                    precioAlquiler += (alquiler.getDias() - 2) * 1.5;
                break;
            case Pelicula.INFANTIL:
                precioAlquiler += 1.5;
                if (alquiler.getDias() > 3)
                    precioAlquiler += (alquiler.getDias() - 3) * 1.5;
                break;
        }
        return precioAlquiler;
    }

    public int getPuntosAlquiler(Alquiler alquiler) {
        int puntosAlquiler = 1;
        if ((alquiler.getPelicula().getCategoria() == Pelicula.NOVEDAD) && alquiler.getDias() > 1)
            puntosAlquiler = 2;
        return puntosAlquiler;
    }

}
```

Y la clase `Cliente` ya no tiene porque saber como se calculan dichos alquileres, simplemente llama al alquiler para que
lo haga:
````java
public class Cliente {
    
    //...

    public void imprimeInforme() {
        double totalPrecio = 0;
        int totalPuntos = 0;
        System.out.println("Informe de los alquileres de: " + getNombre());

        for (Alquiler alquiler : alquileres) {

            // 1) Calcula el importe de cada alquiler
            double precioAlquiler = alquiler.getPrecioAlquiler(alquiler);

            // 2) Cada alquiler da 1 punto. Punto extra para novedades alquiladas 2 o m�s d�as
            int puntosAlquiler = alquiler.getPuntosAlquiler(alquiler);

            // 3) Acumula los totales
            totalPrecio += precioAlquiler;
            totalPuntos += puntosAlquiler;

            // 4) Muestra el importe de este alquiler
            System.out.println("\t- " + alquiler.getPelicula().getTitulo() + "\t" + precioAlquiler + "€");

        }

        System.out.println("La deuda es de " + totalPrecio + "€.\n");
        System.out.println("Ha obtenido " + totalPuntos + " puntos en tu tarjeta.");
    }
}
````

Lo siguiente que hicimos fue pasar la responsabilidad de que se calcule el precio según la pelicula a la propia película.
Para ello, se pasamos la clase `Pelicula`a una interfaz con los métodos `getTitulo()`, `getPrecioAlquiler(alquiler)` y 
`getPuntosAlquiler(alquiler)`, delegando la implementación de estos a las clases concretas `PeliculaNovedad`, 
`PeliculaNormal` y `PeliculaInfantil`.  
Así hemos conseguido que se cumpla el principio de abierto-cerrado, haciendo que si queremos añadir nuevos tipos de 
películas solo tengamos que crear una nueva clase e implementando los métodos como correspodan.  
Además, ahora el alquiler no tiene porque preocuparse de los tipos de película que haya, simplemente llama al método que
corresponda de la película que tiene:
````java
public class Alquiler {
    private Pelicula pelicula;
    private int dias;
    private double precioAlquiler;
    private int puntosAlquiler;

    public Alquiler(Pelicula pelicula, int dias) {
        this.pelicula = pelicula;
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public double getPrecioAlquiler() {
        precioAlquiler = pelicula.getPrecioAlquiler(this);
        return precioAlquiler;
    }

    public int getPuntosAlquiler() {
        puntosAlquiler = pelicula.getPuntosAlquiler(this);
        return puntosAlquiler;
    }

}
````

Finalmente nos quedaría este diagrama UML:
