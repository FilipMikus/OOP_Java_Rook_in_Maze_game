package sk.stuba.fei.uim.oop.game.view.components;

import sk.stuba.fei.uim.oop.game.controller.Controller;
import sk.stuba.fei.uim.oop.game.view.components.painter.Painter;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends Canvas {
    private final Painter painter;

    public GameCanvas(Controller controller) {
        super();
        painter = new Painter(controller);
        int width = 30 * controller.getMazeGrid()[0].length;
        int height = 30 * controller.getMazeGrid().length;
        super.setSize(width, height);
        super.addMouseListener(controller.getCursorListener());
        super.addMouseMotionListener(controller.getCursorListener());
        super.setFocusable(false);
    }

    @Override
    public void paint(Graphics graphics) {
        painter.paintGame(this, graphics);
        super.repaint();
    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
