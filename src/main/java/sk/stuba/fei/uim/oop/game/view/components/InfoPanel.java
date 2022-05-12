package sk.stuba.fei.uim.oop.game.view.components;

import sk.stuba.fei.uim.oop.game.controller.Controller;

import java.awt.*;

public class InfoPanel extends Canvas {
    private final Controller controller;

    public InfoPanel(Controller controller) {
        super();
        this.controller = controller;
        super.setFocusable(false);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Solved games: " + controller.getSolvedGameCounter(), 63, 20);
        super.repaint();
    }
}
