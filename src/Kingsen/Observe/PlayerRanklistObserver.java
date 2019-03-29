package Kingsen.Observe;

import Kingsen.Game.Game;
import Kingsen.Game.Player;

import java.util.*;

public class PlayerRanklistObserver extends Observer {

    private Game game;

    public PlayerRanklistObserver(Game game, Player player) {
        player.addObserver(this);
        this.game = game;
    }

    @Override
    public void update() {
        List<Player> players = new ArrayList<>(game.getPlayers());
        Collections.sort(players);
        game.setPlayerRanklist(players);
    }
}
