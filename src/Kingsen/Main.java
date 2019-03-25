package Kingsen;

import Kingsen.Command.StartGameCommand;
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

        // Parent root = FXMLLoader.load(getClass().getResource("Main-no-styling.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-no-styling.fxml"));
        Parent root = loader.load();

        // TODO: Start from below
        // loader.setController();

        primaryStage.setTitle("Kingsen App");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        /*game.executeCommand(new AddPlayerCommand(game, new Player("Yosh")));
        game.executeCommand(new AddPlayerCommand(game, new Player("Aron")));
        game.getPlayerNames();*/

        launch(args);
    }
}
