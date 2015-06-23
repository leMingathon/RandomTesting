package randomtesting;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage window;

    private VBox layout1;
    private Scene mainScene;

    private Label label1;
    private Button button1a;
    private Button button1b;

    private GridPane layout2;
    private Scene scene2;

    private Label label2;
    private TextField field2;
    private CheckBox checkBox2;
    private ChoiceBox<String> choiceBox2;
    private ComboBox<String> comboBox2;
    private ListView<String> listView2;

    private TreeView<String> treeView2;
    // The ROOT
    private TreeItem<String> root;
    // The PARENTS
    private TreeItem<String> parent1;
    private TreeItem<String> parent2;
    // The CHILDREN
    private TreeItem<String> child1a;
    private TreeItem<String> child2a;
    private TreeItem<String> child2b;

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

        label1 = new Label("Awesomeness!");
        button1a = new Button("Click me to go to Scene 2!");
        button1a.setOnAction(e -> window.setScene(scene2));
        button1b = new Button("Close this stupid BS thing");
        button1b.setOnAction(e -> windowClosing());

        layout1.getChildren().addAll(label1, button1a, button1b);
        mainScene = new Scene(layout1, 500, 300);

        layout2 = new GridPane();
        layout2.setAlignment(Pos.CENTER);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        layout2.setHgap(5);
        layout2.setVgap(10);

        label2 = new Label("Sup! This is Scene 2!");
        GridPane.setConstraints(label2, 0, 0);
        field2 = new TextField();
        field2.setPrefWidth(200);
        field2.setPromptText("Type some stoooooff in here!");
//        field2.setOnKeyTyped(event -> DialogBox.displayAlert("Dialog", "Something just happened!"));
        GridPane.setConstraints(field2, 1, 0, 2, 1);
        checkBox2 = new CheckBox("Select me!");
        GridPane.setConstraints(checkBox2, 1, 1);

        choiceBox2 = new ChoiceBox<>();
        choiceBox2.getItems().addAll("Your mum", "Your dad", "Your face", "Your moustache");
        choiceBox2.setValue("Your face");
        // THIS IS QUITE LONG...
        choiceBox2.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->
                        DialogBox.displayAlert("Dialog", "Selected item is now " + newValue));
        GridPane.setConstraints(choiceBox2, 1, 2);

        comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll("My mum", "My dad", "My face", "My moustache");
        comboBox2.setVisibleRowCount(2);
//        comboBox2.setEditable(true);
//        comboBox2.setValue("My moustache");
        comboBox2.setPromptText("Pick one of these dings!");
        comboBox2.setOnAction(event -> DialogBox.displayAlert("Dialog", "Hey! You picked "
                + comboBox2.getValue() + "! :D"));
        GridPane.setConstraints(comboBox2, 2, 2);

        listView2 = new ListView<>();
        listView2.getItems().addAll("Hey", "What", "The", "F", "Is", "Wrong", "With", "You?");
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        GridPane.setConstraints(listView2, 1, 3, 2, 1);

        treeView2 = new TreeView<>();
        // Remember this!
        treeView2.setShowRoot(false);
//        treeView2.setEditable(true);
        root = new TreeItem<>();
        root.setExpanded(true);
        parent1 = new TreeItem<>("Bob");
        parent2 = new TreeItem<>("Jenny");
        parent1.setExpanded(true);
        parent2.setExpanded(true);
        child1a = new TreeItem<>("Fiace");
        child2a = new TreeItem<>("Murchie");
        child2b = new TreeItem<>("Murcheeeeeeee");

        treeView2.setRoot(root);
        root.getChildren().addAll(parent1, parent2);
        parent1.getChildren().addAll(child1a);
        parent2.getChildren().addAll(child2a, child2b);
        treeView2.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                        -> DialogBox.displayAlert("Dialog", "Selected item is now: "
                        + treeView2.getSelectionModel().getSelectedItem().getValue()));
        GridPane.setConstraints(treeView2, 1, 4, 2, 1);

        button2a = new Button("Click this sexy thing!");
        button2a.setOnAction(event -> {
            DialogBox.displayAlert("Dialog", "Value of field: " + field2.getText());
            DialogBox.displayAlert("Dialog", "Is the checkbox selected? " + (checkBox2.isSelected() ? "Yes" : "No"));
            for (String s : listView2.getSelectionModel().getSelectedItems()) {
                DialogBox.displayAlert("Dialog", "Selected item from listView2: " + s);
            }
        });
        GridPane.setConstraints(button2a, 1, 5);
        button2b = new Button("Return to the Main Scene");
        button2b.setOnAction(event -> window.setScene(mainScene));
        GridPane.setConstraints(button2b, 0, 6, 2, 1);

        layout2.getChildren().addAll(label2, field2, checkBox2, choiceBox2, comboBox2, listView2,
                treeView2, button2a, button2b);
        scene2 = new Scene(layout2, 500, 300);
        // This line of code is IMPORTANT!
        scene2.getStylesheets().add(getClass().getResource("").toExternalForm());
//        scene2.setUserAgentStylesheet(STYLESHEET_MODENA);
        // NOTE: initialise the Scene AFTER adding everything to the layout, and THEN request focus!
        button2a.requestFocus();

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
