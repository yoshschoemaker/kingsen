package ui;

import Kingsen.Build.Card;
import Kingsen.Command.CardChosenCommand;
import Kingsen.Controller;
import Kingsen.Helpers.ConsoleColors;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class gameController extends Controller {

    @FXML
    private HBox cardContainer;

    @FXML
    private Text kingsLeftToFind;

    @FXML
    private Text playerTurnName;

    @Override
    public void afterInitialization() {
        game.start();
        kingsLeftToFind.setText(Integer.toString(game.getKingsLeft()));
        playerTurnName.setText(game.getTurn().getCurrentPlayer().getName() + "'s turn");

        if (game.isGameOver()) {
            System.out.println(ConsoleColors.RED + "GAME OVER!" + ConsoleColors.RESET);
            switchScene("gameOver");
            return;
        }

        for (Card card : game.getCards()) {
            try {
                HBox imageViewHbox = FXMLLoader.load(getClass().getResource("DataTemplates/SingleCard.fxml"));
                imageViewHbox.setUserData(card);
                imageViewHbox.setOnMouseClicked(this::cardClicked);
                cardContainer.getChildren().add(imageViewHbox);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Will be called on a card click,
     * should open the card.
     */
    public void cardClicked(Event event) {
        HBox cardHBox = (HBox) event.getSource();
        Card card = (Card) cardHBox.getUserData();
        cardContainer.getChildren().remove(cardHBox);


        if (card.isNumberCard()) {
            System.out.println(String.format("%1$s has picked card with number %2$s", game.getTurn().getCurrentPlayer().getName(), card.getNumber()));
        } else {
            System.out.println(String.format("%1$s has picked card with face %2$s", game.getTurn().getCurrentPlayer().getName(), card.getFace()));
        }

        System.out.println(String.format("%1$s: %2$s", card.getRule().getRuleTitle(), card.getRule().getDescription()));

        System.out.println(ConsoleColors.BLUE + game.getTurn().getCurrentPlayer().getName() + "'s turn now - " + game.getKingsLeft() + " king card(s) left." + ConsoleColors.RESET);

        game.executeCommand(new CardChosenCommand(game, card));

        switchSceneWithCard("card", card);
    }

    public void openMenuClicked(MouseEvent event) {
        switchScene("menu");
    }
}
