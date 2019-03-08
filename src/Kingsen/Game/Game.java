package Kingsen.Game;

import Kingsen.Command.Command;

import java.util.*;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void init() {
        System.out.println("--GAME STARTED--\n\n");
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    public void getPlayerNames() {
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
