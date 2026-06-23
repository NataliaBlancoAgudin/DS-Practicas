package nodos;

import visitor.Visitor;

public class Variable implements Expresion {
	public String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
		return v.visit(this, param);
	}
}
