package Kingsen;

import Kingsen.Command.*;
import Kingsen.Game.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Kingsen App");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.init();

        game.executeCommand(new AddPlayerCommand(game, new Player("Yosh")));
        game.executeCommand(new AddPlayerCommand(game, new Player("Aron")));
        game.getPlayerNames();

        launch(args);
    }
}
