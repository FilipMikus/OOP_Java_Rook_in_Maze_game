package sk.stuba.fei.uim.oop.game.model;

import lombok.Getter;

import java.util.Collections;
import java.util.Stack;

public class Maze {
    private final char wallCell;
    private final char paddingCell;
    private final char visitedCell;
    private final char finishCell;
    @Getter
    private final char[][] mazeGrid;

    public Maze(int rows, int columns) {
        wallCell = 'W';
        paddingCell = 'P';
        visitedCell = 'V';
        finishCell = 'F';
        mazeGrid = new char[rows * 2 + 1][columns * 2 + 1];
        generateMaze();
    }

    public void generateMaze() {
        createMazeGrid();
        randomizedDFS(1, 1);
    }

    private void createMazeGrid() {
        for (int y = 0; y < mazeGrid.length; y++)
            for (int x = 0; x < mazeGrid[0].length; x++)
                if (x % 2 == 1 && y % 2 == 1)
                    mazeGrid[y][x] = paddingCell;
                else
                    mazeGrid[y][x] = wallCell;
    }

    private void randomizedDFS(int xStart, int yStart) {
        recursiveRandomizedDFS(xStart, yStart);
        mazeGrid[mazeGrid.length - 2][mazeGrid[0].length - 2] = finishCell;
    }

    private void recursiveRandomizedDFS(int x, int y) {
        mazeGrid[y][x] = visitedCell;
        //BASE CASE:
        if (!haveReachableNeighborCells(x, y))
            return;
        Stack<int[]> tmpReachableNeighborCells = getReachableNeighborCellsOf(x, y);
        randomizeNeighborsCells(tmpReachableNeighborCells);
        int[] tmpCell;
        while (!tmpReachableNeighborCells.empty()) {
            tmpCell = tmpReachableNeighborCells.pop();
            if (haveReachableNeighborCells(x, y)) {
                createPaddingToCell(x, y, tmpCell[0], tmpCell[1]);
                recursiveRandomizedDFS(tmpCell[0], tmpCell[1]);
            }
        }
    }

    private boolean haveReachableNeighborCells(int x, int y) {
        if (isNorthNeighborCellReachable(x, y))
            return true;
        else if (isSouthNeighborCellReachable(x, y))
            return true;
        else if (isWestNeighborCellReachable(x, y))
            return true;
        else if (isEastNeighborCellReachable(x, y))
            return true;
        return false;
    }

    private Stack<int[]> getReachableNeighborCellsOf(int x, int y) {
        Stack<int[]> tmpReachableNeighborCells = new Stack<>();
        if (isNorthNeighborCellReachable(x, y))
            tmpReachableNeighborCells.push(new int[]{x, y - 2});
        if (isSouthNeighborCellReachable(x, y))
            tmpReachableNeighborCells.push(new int[]{x, y + 2});
        if (isWestNeighborCellReachable(x, y))
            tmpReachableNeighborCells.push(new int[]{x - 2, y});
        if (isEastNeighborCellReachable(x, y))
            tmpReachableNeighborCells.push(new int[]{x + 2, y});
        return tmpReachableNeighborCells;
    }

    private boolean isNorthNeighborCellReachable(int x, int y) {
        return y - 2 > 0 && mazeGrid[y - 2][x] == paddingCell;
    }

    private boolean isSouthNeighborCellReachable(int x, int y) {
        return y + 2 < mazeGrid.length - 1 && mazeGrid[y + 2][x] == paddingCell;
    }

    private boolean isWestNeighborCellReachable(int x, int y) {
        return x - 2 > 0 && mazeGrid[y][x - 2] == paddingCell;
    }

    private boolean isEastNeighborCellReachable(int x, int y) {
        return x + 2 < mazeGrid[y].length - 1 && mazeGrid[y][x + 2] == paddingCell;
    }

    private void randomizeNeighborsCells(Stack<int[]> reachableNeighborCells) {
        Collections.shuffle(reachableNeighborCells);
    }

    private void createPaddingToCell(int x, int y, int xNeighbor, int yNeighbor) {
        if (x == xNeighbor)
            if (y > yNeighbor)
                mazeGrid[y - 1][xNeighbor] = paddingCell;
            else
                mazeGrid[y + 1][xNeighbor] = paddingCell;
        else if (x > xNeighbor)
            mazeGrid[yNeighbor][x - 1] = paddingCell;
        else
            mazeGrid[yNeighbor][x + 1] = paddingCell;
    }

    public boolean isWallCell(int x, int y) {
        return mazeGrid[y][x] == wallCell;
    }

    public boolean isFinishCell(int x, int y) {
        return mazeGrid[y][x] == finishCell;
    }
}
