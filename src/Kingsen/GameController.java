package Kingsen;

import Kingsen.Build.Card;
import Kingsen.Command.CardChosenCommand;
import Kingsen.Helpers.ConsoleColors;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * @deprecated This was a test class and is no longer in use. It should be ignored!
 */
@Deprecated
public class GameController extends Controller {

    @FXML
    private VBox container;

    @FXML
    private HBox cardsContainer;

    @Override
    public void afterInitialization() {
        game.start();

        int i = 1;
        for (Card card : game.getCards()) {
            try {
                Button btn = FXMLLoader.load(getClass().getResource("DataTemplates/GameCard.fxml"));
                btn.setText(Integer.toString(i));
                btn.setUserData(card);
                btn.setOnAction(this::cardChosen);
                cardsContainer.getChildren().add(btn);
            } catch (IOException e) {
                e.printStackTrace();
            }

            i++;
        }
    }

    private void cardChosen(Event event) {
        Button btn = (Button) event.getSource();
        Card card = (Card) btn.getUserData();
        //btn.setVisible(false);
        cardsContainer.getChildren().remove(btn);

        if (!game.isGameOver()) {
            if (card.isNumberCard()) {
                System.out.println(String.format("%1$s has picked card with number %2$s", game.getTurn().getCurrentPlayer().getName(), card.getNumber()));
            } else {
                System.out.println(String.format("%1$s has picked card with face %2$s", game.getTurn().getCurrentPlayer().getName(), card.getFace()));
            }

            System.out.println(String.format("%1$s: %2$s", card.getRule().getRuleTitle(), card.getRule().getDescription()));

            // game.executeCommand(new SelectLoserCommand(game, game.getTurn().getCurrentPlayer()));
            game.executeCommand(new CardChosenCommand(game, card));
            System.out.println(ConsoleColors.BLUE + game.getTurn().getCurrentPlayer().getName() + "'s turn now - " + game.getKingsLeft() + " king card(s) left." + ConsoleColors.RESET);

            /*for (Player player : game.getPlayerRanklist()) {
                System.out.println(player.toString());
            }*/
        } else {
            System.out.println(ConsoleColors.RED + "GAME OVER!" + ConsoleColors.RESET);
        }
    }
}
