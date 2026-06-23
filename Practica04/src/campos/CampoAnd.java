package campos;

public class CampoAnd implements Validable{

    private Validable[] listaValidables;

    public CampoAnd(Validable... listaValidables) {
        this.listaValidables = listaValidables;
    }

    @Override
    public boolean isValid(String texto) {
        for(Validable validable : listaValidables) {
            if(!validable.isValid(texto)) {
                return false;
            }
        }
        return true;
    }
}
