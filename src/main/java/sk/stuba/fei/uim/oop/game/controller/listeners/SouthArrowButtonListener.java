package sk.stuba.fei.uim.oop.game.controller.listeners;

import sk.stuba.fei.uim.oop.game.controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthArrowButtonListener implements ActionListener {
    private final Controller controller;

    public SouthArrowButtonListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!controller.isRookClicked())
            controller.southRookShiftUpdate();
    }
}
