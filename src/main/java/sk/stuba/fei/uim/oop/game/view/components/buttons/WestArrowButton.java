package sk.stuba.fei.uim.oop.game.view.components.buttons;

import sk.stuba.fei.uim.oop.game.controller.Controller;

import javax.swing.*;

public class WestArrowButton extends JButton {

    public WestArrowButton(Controller controller) {
        super("◀");
        super.addActionListener(controller.getWestArrowButtonListener());
        super.setFocusable(false);
    }
}
