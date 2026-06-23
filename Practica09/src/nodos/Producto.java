package nodos;

import visitor.Visitor;

public class Producto implements Expresion {
	public Expresion left, right;

	public Producto(Expresion left, Expresion right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
		return v.visit(this, param);
	}

}
