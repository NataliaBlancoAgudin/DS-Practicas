public class Temperatura {
    private double celsius;
    private boolean okCelsius;
    private boolean okFar;
    private double fahrenheit;

    public void setCelsius(double celsius) {
        this.celsius = celsius;
        this.okCelsius = true;
        this.okFar = false;
    }

    public void setFar(double far){
        this.fahrenheit = far;
        this.okFar = true;
        this.okCelsius = false;
    }

    public double getCelsius() {
        if(!okCelsius){
            celsius = (fahrenheit - 32) / 1.8;
            okCelsius = true;
        }
        return celsius;
    }

    public double getFahrenheit() {
        if(!okFar){
            fahrenheit = celsius * 1.8 + 32;
            okFar = true;
        }
        return fahrenheit;
    }
}

// OTRA FORMA: (le gusta mas a enol) -> se aprovecha de que los objetos son null
//public class Temperatura {
//    private Double celsius;
//    private Double fahrenheit;
//
//    public void setCelsius(double celsius) {
//        this.celsius = celsius;
//        fahrenheit=null;
//    }
//
//    public void setFar(double far){
//        this.fahrenheit = (far - 32) / 1.8;
//        celsius=null;
//    }
//
//    public double getCelsius() {
//        if(celsius == null){
//            celsius = (fahrenheit - 32) / 1.8;
//        }
//        return celsius;
//    }
//
//    public double getFahrenheit() {
//        if(fahrenheit == null){
//            fahrenheit = celsius * 1.8 + 32;
//        }
//        return fahrenheit * 1.8 + 32;
//    }
//}

//OTRA FORMA: (le gusta mas a enol) -> utilizamos optional
//import java.util.Optional;
//public class Temperatura {
//    private Optional<Double> celsius;
//    private Optional<Double> fahrenheit;
//
//    public void setCelsius(double celsius) {
//        this.celsius = Optional.of(celsius);
//        fahrenheit= Optional.empty();
//    }
//
//    public void setFar(double far){
//        this.fahrenheit = Optional.of(far);
//        celsius= Optional.empty();
//    }
//
//    public double getCelsius() {
//        if(celsius.isEmpty()){
//            celsius = Optional.of((fahrenheit.get() - 32) / 1.8);
//        }
//        return celsius.get();
//    }
//
//    public double getFahrenheit() {
//        if(fahrenheit.isEmpty()){
//            fahrenheit = Optional.of(celsius.get() * 1.8 + 32);
//        }
//        return fahrenheit.get() * 1.8 + 32;
//    }
//}
