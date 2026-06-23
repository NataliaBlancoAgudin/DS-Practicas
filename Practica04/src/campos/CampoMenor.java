package campos;

public class CampoMenor implements Validable{

    private int numero;

    public CampoMenor(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean isValid(String texto) {
        return Integer.parseInt(texto) < numero;
    }
}
