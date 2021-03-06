package ui;

import Kingsen.Command.NextTurnCommand;
import Kingsen.Command.SelectLoserCommand;
import Kingsen.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class cardController extends Controller {

    @FXML
    private Text ruleTitle;

    @FXML
    private Label ruleDescription;

    @FXML
    private Text cardNumberOrFace;

    @FXML
    private Text kingsLeftToFind;

    @FXML
    private ImageView cardTypeImage;

    @FXML
    private VBox cardVbox;

    @FXML
    private Text hasPickedCardText;

    @Override
    public void afterInitialization() {
        if (card != null) {
            ruleTitle.setText(card.getRule().getRuleTitle());
            ruleDescription.setText(card.getRule().getDescription());
            kingsLeftToFind.setText(Integer.toString(game.getKingsLeft()));
            hasPickedCardText.setText(game.getTurn().getCurrentPlayer().getName() + " has picked this card");

            if (card.isNumberCard()) {
                cardNumberOrFace.setText(Integer.toString(card.getNumber()));
            } else {
                cardNumberOrFace.setText(card.getFace().toString());
            }

            String typeLowercased = card.getType().toString().toLowerCase();

            cardVbox.getStyleClass().removeAll();
            cardVbox.getStyleClass().add("card");
            cardVbox.getStyleClass().add(typeLowercased);

            cardTypeImage.setImage(new Image(getClass().getResourceAsStream("assets/images/" + card.getType().toString().toLowerCase() + ".png")));
        }
    }

    /**
     * Will be called when the 'continue' button is clicked
     * will either refer to 'select loser' screen or the 'game' screen.
     */
    public void continueClicked(MouseEvent event) {

        if (!card.getProperties().isPenaltyEnabled()) {
            game.executeCommand(new NextTurnCommand(game));
            switchScene("game");
        } else {
            if (card.getProperties().isSelfPenalty()) {
                game.executeCommand(new SelectLoserCommand(game, game.getTurn().getCurrentPlayer()));
                game.executeCommand(new NextTurnCommand(game));
                switchScene("game");
            } else {
                game.executeCommand(new NextTurnCommand(game));
                switchScene("givePenalty");
            }
        }
    }

    public void openMenuClicked(MouseEvent event) {
        switchSceneWithCard("menu", card);
    }
}
