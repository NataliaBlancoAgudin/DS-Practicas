package nodos;

import visitor.Visitor;

public interface Nodo {
    <RT,PT> RT accept(Visitor<RT,PT> v, PT param);

}
