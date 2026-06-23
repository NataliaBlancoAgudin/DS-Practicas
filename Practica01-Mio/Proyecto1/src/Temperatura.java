public class Temperatura {

    private double celsius;
    private double fahrenheit;

    private boolean isCelsius;
    private boolean isFahrenheit;


    public void setCelsius(double celsius) {
        this.celsius = celsius;
        isCelsius = true;
        isFahrenheit = false;
    }

    public double getCelsius() {
        if(!isCelsius) {
            celsius = (fahrenheit - 32) / 1.8;
            isCelsius = true;
        }
        return celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
        isFahrenheit = true;
        isCelsius = false;
    }

    public double getFahrenheit() {
        if(!isFahrenheit) {
            fahrenheit = celsius * 1.8 + 32;
            isFahrenheit = true;
        }
        return fahrenheit;
    }
}
