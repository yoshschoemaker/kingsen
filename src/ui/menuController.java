package ui;

import Kingsen.Controller;

public class menuController extends Controller {

    public void givePenaltyClicked()
    {
        switchScene("givePenalty");
    }

    public void closeMenuClicked()
    {
        switchScene("game");
    }

    public void quitGameClicked()
    {
        System.exit(0);
    }
}
