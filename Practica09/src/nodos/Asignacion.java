package nodos;

import visitor.Visitor;

public class Asignacion implements Sentencia {
	public Variable variable;
	public Expresion expr;

	public Asignacion(Variable variable, Expresion expr) {
		this.variable = variable;
		this.expr = expr;
	}

	@Override
	public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
		return v.visit(this, param);
	}
}
