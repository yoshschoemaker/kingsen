package ui;

import Kingsen.Controller;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class menuController extends Controller {

    @FXML
    private Text kingsLeftToFind;

    @Override
    public void afterInitialization() {
        kingsLeftToFind.setText(Integer.toString(game.getKingsLeft()));
    }

    public void givePenaltyClicked()
    {
        switchScene("givePenalty");
    }

    public void closeMenuClicked()
    {
        switchToPreviousScene();
    }

    public void quitGameClicked()
    {
        System.exit(0);
    }
}
