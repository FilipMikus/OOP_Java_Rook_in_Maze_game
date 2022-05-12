package sk.stuba.fei.uim.oop.game.model;

import lombok.Getter;

public class Rook {
    private final int xStart;
    private final int yStart;
    @Getter
    private int x;
    @Getter
    private int y;

    public Rook(int xStart, int yStart) {
        this.xStart = xStart;
        this.yStart = yStart;
        x = xStart;
        y = yStart;
    }

    public void northShift() {
        y--;
    }

    public void southShift() {
        y++;
    }

    public void westShift() {
        x--;
    }

    public void eastShift() {
        x++;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveToStart() {
        x = xStart;
        y = yStart;
    }
}
