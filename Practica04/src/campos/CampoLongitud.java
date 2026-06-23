package campos;

public class CampoLongitud implements Validable{

    private int longitud;

    public CampoLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean isValid(String texto) {
        return texto.length() == longitud;
    }
}
