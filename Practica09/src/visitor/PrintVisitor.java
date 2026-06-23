package visitor;

import nodos.*;

public class PrintVisitor<RT,PT> implements Visitor<RT,PT> {
    @Override
    public RT visit(Asignacion asignacion, PT param) {
        asignacion.variable.accept(this, param);
        System.out.print(" = ");
        asignacion.expr.accept(this, param);
        System.out.println(";");
        return null;
    }

    @Override
    public RT visit(ConstanteInt constanteInt, PT param) {
        System.out.print(constanteInt.valor);
        return null;
    }

    @Override
    public RT visit(Division division, PT param) {
        division.left.accept(this, param);
        System.out.print(" / ");
        division.right.accept(this, param);
        return null;
    }

    @Override
    public RT visit(Print print, PT param) {
        System.out.print("print ");
        print.expr.accept(this, param);
        System.out.print(";");
        return null;
    }

    @Override
    public RT visit(Producto producto, PT param) {
        producto.left.accept(this, param);
        System.out.print(" * ");
        producto.right.accept(this, param);
        return null;
    }

    @Override
    public RT visit(Programa programa, PT param) {
        for(Sentencia sentencia: programa.sentencias)
            sentencia.accept(this, param);
        return null;
    }

    @Override
    public RT visit(Read read, PT param) {
        System.out.print("read ");
        read.var.accept(this, param);
        System.out.println(";");
        return null;
    }

    @Override
    public RT visit(Suma suma, PT param) {
        suma.left.accept(this, param);
        System.out.print(" + ");
        suma.right.accept(this, param);
        return null;
    }

    @Override
    public RT visit(Variable variable, PT param) {
        System.out.print(variable.name);
        return null;
    }
}
