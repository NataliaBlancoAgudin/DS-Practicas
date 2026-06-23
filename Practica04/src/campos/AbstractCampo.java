package campos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractCampo implements Campo{

    private String etiqueta;
    private String texto;
    private Validable validable;

    public AbstractCampo(String etiqueta, Validable validable) {
        this.etiqueta = etiqueta;
        this.validable = validable;
    }

    public void pideDato(){
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.print(etiqueta + ": ");
                texto = consola.readLine();

            } catch (IOException ex) {
                System.out.println(ex);
            }
        } while (!validable.isValid(texto));
    }

    public String getDato(){
        return texto;
    }
}
