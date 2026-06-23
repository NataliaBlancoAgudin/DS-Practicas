package campos;

public class CampoPredefinido implements Validable {

    private String[] valores;

    public CampoPredefinido(String... valores) {
        this.valores = valores;
    }

    @Override
    public boolean isValid(String texto) {
        boolean valido = false;
        for (String valor : valores) {
            if (texto.toLowerCase().equals(valor.toLowerCase())) {
                valido = true;
                break;
            }
        }
        return valido;
    }
}
