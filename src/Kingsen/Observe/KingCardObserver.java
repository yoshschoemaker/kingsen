package Kingsen.Observe;

import Kingsen.Build.Card;
import Kingsen.Build.Face;
import Kingsen.Game.Game;

/**
 * This Observer class keep tracks of how many King cards there are left in the Game
 * and sets the amount of King cards left
 */
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
