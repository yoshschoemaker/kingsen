package Kingsen;

import Kingsen.Game.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game();
        game.init();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-no-styling.fxml"));
        Parent root = loader.load();
        IntroController introController = loader.getController();
        introController.setGame(game);
        introController.setCurrStage(primaryStage);
        primaryStage.setTitle("Kingsen App");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
