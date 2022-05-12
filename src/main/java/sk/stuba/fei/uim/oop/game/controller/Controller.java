package sk.stuba.fei.uim.oop.game.controller;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.game.controller.listeners.*;
import sk.stuba.fei.uim.oop.game.model.Model;

@Getter
public class Controller {
    private final Model model;
    private final CursorListener cursorListener;
    private final KeyboardListener keyboardListener;
    private final NewGameButtonListener newGameButtonListener;
    private final NorthArrowButtonListener northArrowButtonListener;
    private final SouthArrowButtonListener southArrowButtonListener;
    private final WestArrowButtonListener westArrowButtonListener;
    private final EastArrowButtonListener eastArrowButtonListener;
    @Setter
    private boolean rookClicked;

    public Controller(Model model) {
        this.model = model;
        cursorListener = new CursorListener(this);
        keyboardListener = new KeyboardListener(this);
        newGameButtonListener = new NewGameButtonListener(this);
        northArrowButtonListener = new NorthArrowButtonListener(this);
        southArrowButtonListener = new SouthArrowButtonListener(this);
        westArrowButtonListener = new WestArrowButtonListener(this);
        eastArrowButtonListener = new EastArrowButtonListener(this);
        rookClicked = false;
    }

    public void switchRookClicked() {
        rookClicked = !rookClicked;
    }

    public void reachableCellsFromCurrentRookPositionUpdate() {
        model.reachableCellsFromCurrentRookPositionUpdate();
    }

    public void newGameUpdate() {
        model.newGameUpdate();
    }

    public void northRookShiftUpdate() {
        model.northRookShiftUpdate();
    }

    public void southRookShiftUpdate() {
        model.southRookShiftUpdate();
    }

    public void westRookShiftUpdate() {
        model.westRookShiftUpdate();
    }

    public void eastRookShiftUpdate() {
        model.eastRookShiftUpdate();
    }

    public void rookPositionChangeUpdate(int x, int y) {
        model.rookPositionChangeUpdate(x, y);
    }

    public boolean isWallCell(int x, int y) {
        return model.isWallCell(x, y);
    }

    public boolean isFinishCell(int x, int y) {
        return model.isFinishCell(x, y);
    }

    public char[][] getMazeGrid() {
        return model.getMazeGrid();
    }

    public int getSolvedGameCounter() {
        return model.getSolvedMazeCounter();
    }

    public int getXRook() {
        return model.getXRook();
    }

    public int getYRook() {
        return model.getYRook();
    }

    public Integer[] getReachableCell() {
        for (int i = 0; i < model.getReachableCells().size(); i++) {
            int tmpXCell = model.getReachableCells().get(i)[0];
            int tmpYCell = model.getReachableCells().get(i)[1];
            if (cursorListener.getXMouse() == tmpXCell && cursorListener.getYMouse() == tmpYCell)
                return model.getReachableCells().get(i);
        }
        return null;
    }
}
