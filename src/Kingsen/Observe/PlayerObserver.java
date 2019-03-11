package Kingsen.Observe;

import Kingsen.Game.*;

public abstract class PlayerObserver implements Observer {

    Player player;
    Game game;

    protected PlayerObserver(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    public abstract void update();
}
