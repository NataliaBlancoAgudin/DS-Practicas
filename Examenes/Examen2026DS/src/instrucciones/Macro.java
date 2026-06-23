package instrucciones;

import model.Document;

import java.util.ArrayList;
import java.util.List;

public class Macro implements InstruccionCommand{

    private List<InstruccionCommand> instrucciones;
    private String nombre;

    public Macro(String nombre) {
        this.nombre = nombre;
        instrucciones = new ArrayList<InstruccionCommand>();
    }

    public void addInstruccion(InstruccionCommand instruccion){
        instrucciones.add(instruccion);
    }

    public void removeInstruccion(InstruccionCommand instruccion){
        instrucciones.remove(instruccion);
    }

    public InstruccionCommand getInstruccion(int posicion){
        return instrucciones.get(posicion);
    }

    @Override
    public void execute(Document document) {
        for(InstruccionCommand instruccion : instrucciones){
            instruccion.execute(document);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<InstruccionCommand> getInstrucciones() {
        return instrucciones;
    }
}
