package sk.stuba.fei.uim.oop.game.view.components.buttons;

import sk.stuba.fei.uim.oop.game.controller.Controller;

import javax.swing.*;

public class SouthArrowButton extends JButton {

    public SouthArrowButton(Controller controller) {
        super("▼");
        super.addActionListener(controller.getSouthArrowButtonListener());
        super.setFocusable(false);
    }
}
