package formulario.formularios;

import model.foto.Foto;

public class FormularioFoto implements Formulario {

    private Foto foto;

    public FormularioFoto(Foto foto) {
        this.foto = foto;
    }

    @Override
    public String getValor1() {
        return foto.getUsuario();
    }

    @Override
    public String getValor2() {
        return foto.getDescripción();
    }

    @Override
    public void setValor1(String valor1) {
        foto.setUsuario(valor1);
    }

    @Override
    public void setValor2(String valor2) {
        foto.setDescripción(valor2);
    }

    @Override
    public String getNombreFormulario() {
        return "Foto";
    }

    @Override
    public String getNombreValor1() {
        return "- Usuario";
    }

    @Override
    public String getNombreValor2() {
        return "- Descripción";
    }
}
