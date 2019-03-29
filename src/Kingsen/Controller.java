package Kingsen;

import Kingsen.Build.Card;
import Kingsen.Game.Game;
import Kingsen.Helpers.ConsoleColors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The heart of all other Controllers.
 * This abstract controller should extend any other Controller.
 * This controller passes currStage, game, (optionally) card and previousFxmls references
 * to every new Scene so it can be used everywhere!
 */
public abstract class Controller {

    protected Stage currStage;
    protected Game game;
    protected Card card;
    protected ArrayList<String> previousFxmls;

    /**
     * Switch a scene by .fxml filename.
     * Every reference of other objects are kept alive to the newly created scene.
     *
     * @param fxmlFileName The filename of the .fxml file to open
     */
    public void switchScene(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName + ".fxml"));
            Scene scene = new Scene(loader.load(), currStage.getScene().getWidth(), currStage.getScene().getHeight());
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

    /**
     * Switch a scene by .fxml filename
     * Every reference of other objects are kept alive to the newly created scene.
     * This function is to be used when switching a Scene when a Card is need to be kept referenced for other Scenes.
     *
     * @param fxmlFileName The filename of the .fxml file to open
     * @param card         The card reference that needs to be held when switching the Scene
     */
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

    /**
     * Use this function to return to the scene that was loaded previously
     */
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

    /**
     * @return the String of the name of the previous .fxml file
     */
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
