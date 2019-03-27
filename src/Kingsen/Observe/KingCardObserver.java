package Kingsen.Observe;

import Kingsen.Build.Card;
import Kingsen.Build.Face;
import Kingsen.Game.Game;

public class KingCardObserver extends Observer {

    private Game game;

    public KingCardObserver(Game game) {
        game.addObserver(this);
        this.game = game;
    }

    @Override
    public void update() {
        int countKings = 0;

        for (Card card : game.getCards()) {
            if (card.getFace().equals(Face.KING)) {
                countKings++;
            }
        }

        if (countKings == 0) {
            game.setGameOver(true);
        }

        game.setKingsLeft(countKings);
    }
}
