package sk.stuba.fei.uim.oop.game.view.components;

import sk.stuba.fei.uim.oop.game.controller.Controller;
import sk.stuba.fei.uim.oop.game.view.components.buttons.*;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final Controller controller;

    public ControlPanel(Controller controller) {
        super(new BorderLayout());
        this.controller = controller;
        super.add(createHeader(), BorderLayout.PAGE_START);
        super.add(createFooter(), BorderLayout.PAGE_END);
    }

    private JPanel createHeader() {
        JPanel head = new JPanel(new GridLayout(2, 1));
        head.add(new NewGameButton(controller));
        head.add(new InfoPanel(controller));
        return head;
    }

    private JPanel createFooter() {
        JPanel tile = new JPanel(new GridLayout(2, 3));
        tile.add(new JLabel());
        tile.add(new NorthArrowButton(controller));
        tile.add(new JLabel());
        tile.add(new WestArrowButton(controller));
        tile.add(new SouthArrowButton(controller));
        tile.add(new EastArrowButton(controller));
        return tile;
    }
}
