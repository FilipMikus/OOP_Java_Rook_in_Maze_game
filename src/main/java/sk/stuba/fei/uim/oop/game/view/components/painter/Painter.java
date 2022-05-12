package sk.stuba.fei.uim.oop.game.view.components.painter;

import sk.stuba.fei.uim.oop.game.controller.Controller;
import sk.stuba.fei.uim.oop.game.view.components.painter.icons.*;

import java.awt.*;

public class Painter {
    private final Controller controller;
    private final BrickIcon brickIcon;
    private final RookIcon rookIcon;
    private final RookClickedIcon rookClickedIcon;
    private final GrassIcon grassIcon;
    private final GrassReachableIcon grassReachableIcon;
    private final FinishIcon finishIcon;

    public Painter(Controller controller) {
        this.controller = controller;
        brickIcon = new BrickIcon();
        rookIcon = new RookIcon();
        rookClickedIcon = new RookClickedIcon();
        grassIcon = new GrassIcon();
        grassReachableIcon = new GrassReachableIcon();
        finishIcon = new FinishIcon();
    }

    public void paintGame(Component component, Graphics graphics) {
        paintStaticIcons(component, graphics);
        paintDynamicIcons(component, graphics);
    }

    private void paintStaticIcons(Component component, Graphics graphics) {
        char[][] tmpMazeGrid = controller.getMazeGrid();
        for (int y = 0; y < tmpMazeGrid.length; y++)
            for (int x = 0; x < tmpMazeGrid[0].length; x++)
                if (controller.isWallCell(x, y))
                    brickIcon.paintIcon(component, graphics, x, y);
                else if (controller.isFinishCell(x, y))
                    finishIcon.paintIcon(component, graphics, x, y);
                else
                    grassIcon.paintIcon(component, graphics, x, y);
    }

    private void paintDynamicIcons(Component component, Graphics graphics) {
        if (!controller.isRookClicked())
            rookIcon.paintIcon(component, graphics, controller.getXRook(), controller.getYRook());
        else {
            rookClickedIcon.paintIcon(component, graphics, controller.getXRook(), controller.getYRook());
            Integer[] tmpCell = controller.getReachableCell();
            if (tmpCell != null)
                grassReachableIcon.paintIcon(component, graphics, tmpCell[0], tmpCell[1]);
        }
    }
}
