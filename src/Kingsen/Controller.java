package Kingsen;

import Kingsen.Game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {

    protected Stage currStage;
    protected Game game;

    public void switchScene(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName + ".fxml"));
            Scene scene = new Scene(loader.load());
            Controller currController = loader.getController();
            currController.setGame(game);
            currController.setCurrStage(currStage);
            currStage.setScene(scene);

            currController.afterInitialization();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setCurrStage(Stage stage) {
        this.currStage = stage;
    }

    /**
     * To be called after after initializing
     */
    public void afterInitialization() {
        // Do whatever you want
    }
}
