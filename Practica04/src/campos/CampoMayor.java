package campos;

public class CampoMayor implements Validable{

    private int numero;

    public CampoMayor(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean isValid(String texto) {
        return Integer.parseInt(texto) > numero;
    }
}
