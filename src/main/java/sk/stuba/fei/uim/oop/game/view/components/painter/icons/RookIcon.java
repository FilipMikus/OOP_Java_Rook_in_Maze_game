package sk.stuba.fei.uim.oop.game.view.components.painter.icons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class RookIcon extends ImageIcon {
    private boolean imageLoaded;

    public RookIcon() {
        super();
        imageLoaded = true;
        URL tmpRookIconURL = RookIcon.class.getClassLoader().getResource("rook.png");
        if (tmpRookIconURL != null) {
            try {
                super.setImage(ImageIO.read(tmpRookIconURL));
            } catch (IOException ioException) {
                imageLoaded = false;
            }
        } else
            imageLoaded = false;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        if (imageLoaded) {
            super.paintIcon(component, graphics, 30 * x, 30 * y);
        } else {
            graphics.setColor(Color.YELLOW);
            graphics.fillRect(30 * x, 30 * y, 30, 30);
        }
    }
}
