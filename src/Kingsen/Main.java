package Kingsen;

import Kingsen.Game.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.startController;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game();
        ArrayList<String> previousFxmls = new ArrayList<>();
        game.init();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/start-responsive.fxml"));
        Parent root = loader.load();
        startController startController = loader.getController();
        startController.setGame(game);
        startController.setCurrStage(primaryStage);
        startController.setPreviousFxmls(previousFxmls);
        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(500);
        primaryStage.setTitle("Kingsen App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
