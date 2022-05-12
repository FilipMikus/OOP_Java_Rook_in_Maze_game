package sk.stuba.fei.uim.oop.game.controller.listeners;

import sk.stuba.fei.uim.oop.game.controller.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private final Controller controller;

    public KeyboardListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!controller.isRookClicked())
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_UP:
                    controller.northRookShiftUpdate();
                    break;
                case KeyEvent.VK_DOWN:
                    controller.southRookShiftUpdate();
                    break;
                case KeyEvent.VK_LEFT:
                    controller.westRookShiftUpdate();
                    break;
                case KeyEvent.VK_RIGHT:
                    controller.eastRookShiftUpdate();
                    break;
            }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
