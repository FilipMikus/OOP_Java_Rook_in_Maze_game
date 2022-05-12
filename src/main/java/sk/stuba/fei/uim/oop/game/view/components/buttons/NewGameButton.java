package sk.stuba.fei.uim.oop.game.view.components.buttons;

import sk.stuba.fei.uim.oop.game.controller.Controller;

import javax.swing.*;

public class NewGameButton extends JButton {

    public NewGameButton(Controller controller) {
        super("New Game");
        super.addActionListener(controller.getNewGameButtonListener());
        super.setFocusable(false);
    }
}
