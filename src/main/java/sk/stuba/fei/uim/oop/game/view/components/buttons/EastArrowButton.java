package sk.stuba.fei.uim.oop.game.view.components.buttons;

import sk.stuba.fei.uim.oop.game.controller.Controller;

import javax.swing.*;

public class EastArrowButton extends JButton {

    public EastArrowButton(Controller controller) {
        super("▶");
        super.addActionListener(controller.getEastArrowButtonListener());
        super.setFocusable(false);
    }
}
