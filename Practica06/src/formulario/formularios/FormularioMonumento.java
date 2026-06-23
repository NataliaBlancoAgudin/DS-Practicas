package formulario.formularios;

import model.monumento.Monumento;

public class FormularioMonumento implements Formulario{

    private Monumento monumento;

    public FormularioMonumento(Monumento monumento) {
        this.monumento = monumento;
    }

    @Override
    public String getValor1() {
        return monumento.getAutor();
    }

    @Override
    public String getValor2() {
        return monumento.getDirección();
    }

    @Override
    public void setValor1(String valor1) {
        monumento.setAutor(valor1);
    }

    @Override
    public void setValor2(String valor2) {
        monumento.setDirección(valor2);
    }

    @Override
    public String getNombreFormulario() {
        return "Monumento";
    }

    @Override
    public String getNombreValor1() {
        return "- Autor";
    }

    @Override
    public String getNombreValor2() {
        return "- Direccion";
    }
}
