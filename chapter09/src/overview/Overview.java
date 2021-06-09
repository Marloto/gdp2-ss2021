package overview;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

class Ding {
    private String name;
    private int nr;

    public Ding(String name, int nr) {
        this.name = name;
        this.nr = nr;
    }
    public String getName() {
        return name;
    }
    public int getNr() {
        return nr;
    }
    public String toString() {
        return "name von det Ding=" + name + ", nr=" + nr + "]";
    }
}

public class Overview extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Labels und Buttons bereits bekannt
        Label label1 = new Label("Label1");
        Button button1 = new Button("Drück mich!");
        
        // CheckBox für Felder zum Abhacken
        CheckBox box1 = new CheckBox("Text!");
        box1.setSelected(true);
        box1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println(box1.isSelected());
            }
        });
        CheckBox box2 = new CheckBox("Weitere Box");
        
        // ToggleButton für runde Anwahl, über ToggleGroup "Zusammenhang" herstellen 
        ToggleGroup tg = new ToggleGroup();
        RadioButton radio1 = new RadioButton("Beschreibung!");
        RadioButton radio2 = new RadioButton("Weitere Besch.!");
        radio1.setToggleGroup(tg);
        radio2.setToggleGroup(tg);
        

        // TextField zur Eingabe von Text
        TextField field = new TextField("First input...");
        
        // Einlesen von gedrückten Tasten!
        field.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                System.out.println("Alt: " + event.isAltDown());
                System.out.println("Shift: " + event.isShiftDown());
                System.out.println("Character: " + event.getText());
            }
        });
        
        // TextArea für große Textflächen
        TextArea area = new TextArea("First TextArea input...");
        
        // PasswordField für verdeckte Eingaben
        PasswordField password = new PasswordField();
        password.setText("ABC"); // ggf. Möglich Text vorher zu setzen
        
        // Textinformationen lassen sich über getText auslesen, Transformation der Texte
        // von da an wie üblich mit String-Operationen möglich
        Button fieldButton = new Button("Absenden");
        fieldButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String text = field.getText();
                System.out.println(text);
                
                String text2 = area.getText();
                System.out.println(text2);
                
                String text3 = password.getText();
                System.out.println(text3);
            }
        });
        
        // ChoiceBox für Auswahlboxen
        ChoiceBox<Ding> box = new ChoiceBox<>();
        
        // Input könnte eine Standard-Liste sein (muss aber nicht)
        List<Ding> standardListe = new ArrayList<>();
        standardListe.add(new Ding("Wert 1", 1));
        standardListe.add(new Ding("Wert 2", 2));
        standardListe.add(new Ding("Wert 3", 3));
        
        // Notwendig ist eine ObservableList, Verwendung von Klassen als Datentypen
        // möglich
        ObservableList<Ding> observableArrayList = FXCollections.observableArrayList(standardListe);
        box.setItems(observableArrayList);
        Button boxButton = new Button();
        boxButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int size = observableArrayList.size() + 1;
                observableArrayList.add(new Ding("Wert " + size, size));
            }
        });
        
        // Auswahl setzen und auslesen über SelectionModel
        box.getSelectionModel().select(0);
        
        box.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SingleSelectionModel<Ding> selectionModel = box.getSelectionModel();
                Ding item = selectionModel.getSelectedItem();
                System.out.println(item.getName() + " - " + item.getNr());
            }
        });
        
        
//        HBox pane = new HBox();
        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(50, 10, 20, 40));
        pane.setAlignment(Pos.CENTER);
        List<Node> children = pane.getChildren();
        children.add(label1);
        children.add(button1);
        children.add(box1);
        children.add(box2);
        children.add(radio1);
        children.add(radio2);
        children.add(field);
//        children.add(area);
        children.add(password);
        children.add(fieldButton);
        children.add(box);
        children.add(boxButton);
        
        // BorderPane
//        BorderPane pane = new BorderPane();
//        pane.setTop(label1);
//        pane.setLeft(field);
//        pane.setCenter(area);
//        pane.setBottom(boxButton);
//        // Beispiel für Alignment
//        BorderPane.setAlignment(field, Pos.CENTER);
        
//        GridPane pane = new GridPane();
//        pane.add(label1, 0, 0);
//        pane.add(button1, 1, 0);
//        pane.add(area, 0, 1, 2, 1);
//        pane.add(box2, 1, 2);
        
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
