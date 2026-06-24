package gui;

import java.awt.*;

import javax.swing.*;

import alineacion.Alineacion;
import alineacion.AlineacionIzquierda;
import model.*;

public class Canvas extends JTextArea {

    private Document document;
    private int lineWidth; // Number of characters per line

    private Alineacion alineacion;


    public Canvas(Document document) {
        setFont(new Font("Monospaced", Font.BOLD, 24));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setEditable(false);

        this.document = document;

        this.alineacion = new AlineacionIzquierda();

        drawDocument();
    }

    public void setAlineacion(Alineacion alineacion) {
        this.alineacion = alineacion;
    }

    /**
     * Adjust the number of characters per line to the given width in pixels.
     * It is invoked when the container window is resized. 
     */
    public void adjustWidth(int width) {
        FontMetrics metrics = getFontMetrics(getFont());
        var charWidth = metrics.charWidth('A');
        var padding = getInsets().left + getInsets().right;
        lineWidth = (width - padding) / charWidth;

        drawDocument();
    }

    public void drawDocument() {
        setText("");

        for (var line : document.getLines()) {

            append(alineacion.alinear(line, lineWidth));

            append("\n");
        }
    }
}
