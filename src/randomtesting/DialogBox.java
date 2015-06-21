package randomtesting;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogBox {

    public static void displayAlert(String title, String message) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Label label = new Label(message);
        Button button = new Button("OK");
        button.setOnAction(e -> {
            stage.close();
        });

        layout.getChildren().addAll(label, button);
        layout.setBorder(Border.EMPTY);
        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.showAndWait();
    }
}
