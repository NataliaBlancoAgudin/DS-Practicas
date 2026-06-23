package nodos;

import visitor.Visitor;

public class Read implements Sentencia {
	public Variable var;

	public Read(Variable var) {
		this.var = var;
	}

	@Override
	public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
		return v.visit(this, param);
	}
}
