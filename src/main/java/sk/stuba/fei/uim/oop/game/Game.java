package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.game.controller.Controller;
import sk.stuba.fei.uim.oop.game.model.Model;
import sk.stuba.fei.uim.oop.game.view.GraphicalUserInterface;

public class Game {

    public Game() {
        Model model = new Model();
        Controller controller = new Controller(model);
        new GraphicalUserInterface(controller);
    }
}
