package sk.stuba.fei.uim.oop.game.view.components.buttons;


import sk.stuba.fei.uim.oop.game.controller.Controller;

import javax.swing.*;

public class NorthArrowButton extends JButton {

    public NorthArrowButton(Controller controller) {
        super("▲");
        super.addActionListener(controller.getNorthArrowButtonListener());
        super.setFocusable(false);
    }
}
