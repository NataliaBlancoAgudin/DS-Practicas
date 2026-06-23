package campos;

public class CampoOr implements Validable{

    private Validable[] listaValidables;

    public CampoOr(Validable ... listaValidables){
        this.listaValidables = listaValidables;
    }

    @Override
    public boolean isValid(String texto) {
        for(Validable validable : listaValidables){
            if(validable.isValid(texto)){
                return true;
            }
        }
        return false;
    }
}
