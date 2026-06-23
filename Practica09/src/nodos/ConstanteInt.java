package nodos;

import visitor.Visitor;

public class ConstanteInt implements Expresion {
    public String valor;

    public ConstanteInt(String valor) {
        this.valor = valor;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }
}
