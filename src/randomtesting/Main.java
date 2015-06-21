package randomtesting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private StackPane layout;
    private Scene mainScene;

    private Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");

        layout = new StackPane();
        mainScene = new Scene(layout, 350, 300);

        button = new Button("Click me!");
        button.setOnAction(e -> {
            if (button.getText().equals("Click me!")) {
                button.setText("Sup! :D");
            } else {
                button.setText("Click me!");
            }
        });

        layout.getChildren().add(button);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
