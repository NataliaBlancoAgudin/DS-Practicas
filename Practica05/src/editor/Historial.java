package editor;

import cambios.Cambios;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<Cambios> undoCambios = new ArrayList<Cambios>();
    private List<Cambios> redoCambios = new ArrayList<>();

    public void addCambios(Cambios cambios) {
        undoCambios.add(cambios);

    }

    public void undo(){
        if(undoCambios.isEmpty()){
            System.out.println("No puedes hacer un undo: no ha habído cambios");
            return;
        }

        Cambios cambio = undoCambios.get(undoCambios.size()-1);
        cambio.undo();

        redoCambios.add(cambio);
    }

    public void redo(){
        if(redoCambios.isEmpty()){
            System.out.println("No puedes hacer un redo: no has deshecho ningún cambio");
            return;
        }

        Cambios cambio = redoCambios.get(redoCambios.size()-1);
        cambio.redo();

        undoCambios.add(cambio);
    }
}
