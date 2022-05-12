package sk.stuba.fei.uim.oop.game.view;

import sk.stuba.fei.uim.oop.game.controller.Controller;
import sk.stuba.fei.uim.oop.game.view.components.ControlPanel;
import sk.stuba.fei.uim.oop.game.view.components.GameCanvas;

import javax.swing.*;
import java.awt.*;

public class GraphicalUserInterface {
    private final Controller controller;

    public GraphicalUserInterface(Controller controller) {
        this.controller = controller;
        createWindow();
    }

    private void createWindow() {
        JFrame window = new JFrame("Rook in maze (104537)");
        window.setLayout(new BorderLayout());
        window.add(new GameCanvas(controller), BorderLayout.CENTER);
        window.add(new ControlPanel(controller), BorderLayout.LINE_END);
        window.pack();
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(controller.getKeyboardListener());
    }
}
