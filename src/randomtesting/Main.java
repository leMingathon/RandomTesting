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
    private Stage window;

    private VBox layout1;
    private Scene mainScene;

    private Label label1;
    private Button button1a;
    private Button button1b;

    private HBox layout2;
    private Scene scene2;

    private Label label2;
    private Button button2a;
    private Button button2b;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        window.setTitle("Hello World!");

        layout1 = new VBox(5);
        layout1.setAlignment(Pos.CENTER);
        mainScene = new Scene(layout1, 500, 300);

        label1 = new Label("Awesomeness!");
        button1a = new Button("Click me to go to Scene 2!");
        button1a.setOnAction(e -> window.setScene(scene2));
        button1b = new Button("Close this stupid BS thing");
        button1b.setOnAction(e -> windowClosing());

        layout1.getChildren().addAll(label1, button1a, button1b);

        layout2 = new HBox(5);
        layout2.setAlignment(Pos.CENTER);
        scene2 = new Scene(layout2, 500, 300);

        label2 = new Label("Sup! This is Scene 2!");
        button2a = new Button("Take me back to the Main Scene!");
        button2a.setOnAction(e -> window.setScene(mainScene));
        button2b = new Button("Show dialog box!");
        button2b.setOnAction(e -> DialogBox.displayAlert("Dialog", "Hellooooooooooo!"));

        layout2.getChildren().addAll(label2, button2a, button2b);

        window.setOnCloseRequest(e -> {
            e.consume();
            windowClosing();
        });
        window.setScene(mainScene);
        window.show();
    }

    private void windowClosing() {
        boolean result = DialogBox.displayConfirm("Dialog", "Are you sure you want to close this window?");
        if (result) {
            window.close();
        }
    }
}
