package gui;

import java.awt.event.*;

import javax.swing.*;

import alineacion.Alineacion;
import alineacion.AlineacionJustificada;
import alineacion.AlineacionIzquierda;
import model.Document;

public class Window extends JFrame {

    private Canvas canvas;

    private JPanel buttonPanel;
    private ButtonGroup buttonGroup;

    private JRadioButton leftButton, justifiedButton;


    public Window(Document document) {
        setTitle(document.getTitle());
        setSize(500, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createButtons();
        add(buttonPanel, "North");

        canvas = new Canvas(document);
        add(canvas, "Center");

        // Adds a listener to resize the canvas when the window resizes
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                canvas.adjustWidth(width);
            }
        });
    }

    private void createButtons() {
        buttonPanel = new JPanel();
        buttonGroup = new ButtonGroup();

        leftButton = addButton("Left", new AlineacionIzquierda());
        justifiedButton = addButton("Justified", new AlineacionJustificada());

        leftButton.setSelected(true);
    }

    private JRadioButton addButton(String buttonText, Alineacion alineacion) {
        var button = new JRadioButton(buttonText);
        buttonPanel.add(button);
        buttonGroup.add(button);
        button.addActionListener(e -> {
            canvas.setAlineacion(alineacion);
            canvas.drawDocument();
        });

        return button;
    }
}
