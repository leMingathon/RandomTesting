package randomtesting;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller2 {
    @FXML
    private Button button;

    public void dealWithIt() {
        button.setText("You clicked me!!!");
    }
}
