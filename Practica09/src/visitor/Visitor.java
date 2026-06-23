package visitor;

import nodos.*;

public interface Visitor<RT,PT> {
    RT visit(Asignacion asignacion, PT param);
    RT visit(ConstanteInt constanteInt, PT param);
    RT visit(Division division, PT param);
    RT visit(Print print, PT param);
    RT visit(Producto producto, PT param);
    RT visit(Programa programa, PT param);
    RT visit(Read read, PT param);
    RT visit(Suma suma, PT param);
    RT visit(Variable variable, PT param);

}
