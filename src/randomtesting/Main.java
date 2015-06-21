package randomtesting;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private VBox layout1;
    private Scene mainScene;

    private Label label1;
    private Button button1;

    private HBox layout2;
    private Scene scene2;

    private Label label2;
    private Button button2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Hello World!");

        layout1 = new VBox(5);
        layout1.setAlignment(Pos.CENTER);
        mainScene = new Scene(layout1, 350, 300);

        label1 = new Label("Awesomeness!");
        button1 = new Button("Click me to go to Scene 2!");
        button1.setOnAction(e -> {
            window.setScene(scene2);
        });

        layout1.getChildren().addAll(label1, button1);

        layout2 = new HBox(5);
        layout2.setAlignment(Pos.CENTER);
        scene2 = new Scene(layout2, 500, 500);

        label2 = new Label("Sup! This is Scene 2!");
        button2 = new Button("Take me back to the Main Scene!");
        button2.setOnAction(e -> {
            window.setScene(mainScene);
        });

        layout2.getChildren().addAll(label2, button2);

        window.setScene(mainScene);
        window.show();
    }
}
