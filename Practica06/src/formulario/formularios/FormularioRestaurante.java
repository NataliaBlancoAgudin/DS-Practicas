package formulario.formularios;

import model.restaurante.Restaurante;

public class FormularioRestaurante implements Formulario{

    private Restaurante restaurante;

    public FormularioRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String getValor1() {
        return restaurante.getNombre();
    }

    @Override
    public String getValor2() {
        return restaurante.getDirección();
    }

    @Override
    public void setValor1(String valor1) {
        restaurante.setNombre(valor1);
    }

    @Override
    public void setValor2(String valor2) {
        restaurante.setDirección(valor2);
    }

    @Override
    public String getNombreFormulario() {
        return "Restaurante";
    }

    @Override
    public String getNombreValor1() {
        return "- Nombre";
    }

    @Override
    public String getNombreValor2() {
        return "- Dirección";
    }
}
