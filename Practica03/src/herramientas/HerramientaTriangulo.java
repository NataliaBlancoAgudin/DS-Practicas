package herramientas;

import editor.Dibujo;
import editor.Editor;
import figuras.Figura;
import figuras.Triangulo;

import java.awt.*;

public class HerramientaTriangulo implements Herramienta {

    private Point[] verticesTriangulo = new Point[3];
    private int numeroVertices = 0;
    private Editor editor;

    public HerramientaTriangulo(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void pinchar(int x, int y) {
        verticesTriangulo[numeroVertices] = new Point(x, y);
        numeroVertices++;
        if(numeroVertices >= 3){
            Figura triangulo = new Triangulo(verticesTriangulo[0], verticesTriangulo[1], verticesTriangulo[2]);
            editor.getDibujo().addFigura(triangulo);
            // Volvemos a la herramienta por defecto
            editor.finHerramienta();
        }
    }

    @Override
    public void soltar(int x, int y) {
        // No se hace nada
    }

    @Override
    public void mover(int x, int y) {
        // No se hace nada
    }
}
