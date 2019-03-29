package Kingsen;

import Kingsen.Build.Card;
import Kingsen.Game.Game;
import Kingsen.Helpers.ConsoleColors;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public abstract class Controller {

    protected Stage currStage;
    protected Game game;
    protected Card card;
    protected ArrayList<String> previousFxmls;

    public void switchScene(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName + ".fxml"));
            Scene scene = new Scene(loader.load());
            Controller currController = loader.getController();
            currController.setGame(game);
            currController.setCurrStage(currStage);
            currController.setPreviousFxmls(previousFxmls);
            currController.previousFxmls.add(fxmlFileName);
            currStage.setScene(scene);
            currController.afterInitialization();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void switchSceneWithCard(String fxmlFileName, Card card) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName + ".fxml"));
            Scene scene = new Scene(loader.load());
            Controller currController = loader.getController();
            currController.setGame(game);
            currController.setCurrStage(currStage);
            currController.setPreviousFxmls(previousFxmls);
            currController.previousFxmls.add(fxmlFileName);
            currController.setCard(card);
            currStage.setScene(scene);
            currController.afterInitialization();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void switchToPreviousScene() {
        if (previousFxmls.size() > 1) {
            if (card != null) {
                switchSceneWithCard(getPreviousSceneName(), card);
            } else {
                switchScene(getPreviousSceneName());
            }
        } else {
            System.out.println(ConsoleColors.RED + "There is no previous scene!" + ConsoleColors.RESET);
        }
    }

    public String getPreviousSceneName() {
        return previousFxmls.get(previousFxmls.size() - 2);
    }

    public void setPreviousFxmls(ArrayList<String> previousFxmls) {
        this.previousFxmls = previousFxmls;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setCurrStage(Stage stage) {
        this.currStage = stage;
    }

    /**
     * To be called after initializing the controller
     */
    public void afterInitialization() {
        // Do whatever you want
    }
}
