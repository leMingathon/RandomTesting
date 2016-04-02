package randomtesting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/example.fxml"));

            primaryStage.setTitle("Your FACE! :P");
            primaryStage.setScene(new Scene(root, 300, 250));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
