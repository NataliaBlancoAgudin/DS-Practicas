package nodos;

import visitor.Visitor;

public class Print implements Sentencia {
	public Expresion expr;

	public Print(Expresion expr) {
		this.expr = expr;
	}

	@Override
	public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
		return v.visit(this, param);
	}
}
