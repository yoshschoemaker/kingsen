package Kingsen.Observe;

import Kingsen.Build.Card;
import Kingsen.Build.Face;
import Kingsen.Game.Game;

public class EndGameObserver extends Observer {

    private Game game;

    public EndGameObserver(Game game) {
        game.addObserver(this);
        this.game = game;
    }

    @Override
    public void update() {
        boolean allKingCardsPicked = true;

        for (Card card : game.getCards()) {
            if (card.getFace().equals(Face.KING)) {
                allKingCardsPicked = false;
            }
        }

        if (allKingCardsPicked) {
            game.setGameOver(true);
        }
    }
}
