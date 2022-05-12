package sk.stuba.fei.uim.oop.game.controller.listeners;

import lombok.Getter;
import sk.stuba.fei.uim.oop.game.controller.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CursorListener implements MouseMotionListener, MouseListener {
    private final Controller controller;
    @Getter
    private int xMouse;
    @Getter
    private int yMouse;

    public CursorListener(Controller controller) {
        this.controller = controller;
    }

    public boolean isMouseOnRook() {
        return xMouse == controller.getXRook() && yMouse == controller.getYRook();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xMouse = e.getX() / 30;
        yMouse = e.getY() / 30;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (!controller.isRookClicked())
            checkAndActivateSelectRookPositionMode();
        else
            checkAndDeactivateSelectRookPositionMode();
    }

    private void checkAndActivateSelectRookPositionMode() {
        if (isMouseOnRook()) {
            controller.switchRookClicked();
            controller.reachableCellsFromCurrentRookPositionUpdate();
        }
    }

    private void checkAndDeactivateSelectRookPositionMode() {
        if (isMouseOnRook())
            controller.switchRookClicked();
        else {
            final Integer[] tmp = controller.getReachableCell();
            if (tmp != null) {
                controller.setRookClicked(false);
                controller.rookPositionChangeUpdate(tmp[0], tmp[1]);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
    }
}
