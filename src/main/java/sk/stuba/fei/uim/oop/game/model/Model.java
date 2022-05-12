package sk.stuba.fei.uim.oop.game.model;

import lombok.Getter;

import java.util.ArrayList;

public class Model {
    private final Maze maze;
    private final Rook rook;
    @Getter
    private final ArrayList<Integer[]> reachableCells;
    @Getter
    private int solvedMazeCounter;

    public Model() {
        maze = new Maze(9, 9);
        rook = new Rook(1, 1);
        reachableCells = new ArrayList<>();
        solvedMazeCounter = 0;
    }

    public void reachableCellsFromCurrentRookPositionUpdate() {
        reachableCells.clear();
        northReachableCellsFromCurrentRookPosition();
        southReachableCellsFromCurrentRookPosition();
        westReachableCellsFromCurrentRookPosition();
        eastReachableCellsFromCurrentRookPosition();
    }

    public void northReachableCellsFromCurrentRookPosition() {
        int tmpXRook = rook.getX();
        int tmpYRook = rook.getY() - 1;
        while (tmpYRook >= 0 && !maze.isWallCell(tmpXRook, tmpYRook)) {
            reachableCells.add(new Integer[]{tmpXRook, tmpYRook});
            tmpYRook--;
        }
    }

    public void southReachableCellsFromCurrentRookPosition() {
        int tmpXRook = rook.getX();
        int tmpYRook = rook.getY() + 1;
        while (tmpYRook < getMazeGrid().length && !maze.isWallCell(tmpXRook, tmpYRook)) {
            reachableCells.add(new Integer[]{tmpXRook, tmpYRook});
            tmpYRook++;
        }
    }

    public void westReachableCellsFromCurrentRookPosition() {
        int tmpXRook = rook.getX() - 1;
        int tmpYRook = rook.getY();
        while (tmpXRook >= 0 && !maze.isWallCell(tmpXRook, tmpYRook)) {
            reachableCells.add(new Integer[]{tmpXRook, tmpYRook});
            tmpXRook--;
        }
    }

    public void eastReachableCellsFromCurrentRookPosition() {
        int tmpXRook = rook.getX() + 1;
        int tmpYRook = rook.getY();
        while (tmpXRook < getMazeGrid()[0].length && !maze.isWallCell(tmpXRook, tmpYRook)) {
            reachableCells.add(new Integer[]{tmpXRook, tmpYRook});
            tmpXRook++;
        }
    }

    public void newGameUpdate() {
        maze.generateMaze();
        rook.moveToStart();
        solvedMazeCounter = 0;
    }

    public void northRookShiftUpdate() {
        if (!maze.isWallCell(rook.getX(), rook.getY() - 1))
            rook.northShift();
    }

    public void southRookShiftUpdate() {
        if (!maze.isWallCell(rook.getX(), rook.getY() + 1)) {
            rook.southShift();
            checkAndMakeSolvedGameUpdate();
        }
    }

    public void westRookShiftUpdate() {
        if (!maze.isWallCell(rook.getX() - 1, rook.getY()))
            rook.westShift();
    }

    public void eastRookShiftUpdate() {
        if (!maze.isWallCell(rook.getX() + 1, rook.getY())) {
            rook.eastShift();
            checkAndMakeSolvedGameUpdate();
        }
    }

    public void rookPositionChangeUpdate(int x, int y) {
        rook.moveTo(x, y);
        checkAndMakeSolvedGameUpdate();
    }

    public void checkAndMakeSolvedGameUpdate() {
        if (rook.getY() == getMazeGrid().length - 2 && rook.getX() == getMazeGrid()[0].length - 2) {
            maze.generateMaze();
            rook.moveToStart();
            solvedMazeCounter++;
        }
    }

    public boolean isWallCell(int x, int y) {
        return maze.isWallCell(x, y);
    }

    public boolean isFinishCell(int x, int y) {
        return maze.isFinishCell(x, y);
    }

    public int getXRook() {
        return rook.getX();
    }

    public int getYRook() {
        return rook.getY();
    }

    public char[][] getMazeGrid() {
        return maze.getMazeGrid();
    }
}
