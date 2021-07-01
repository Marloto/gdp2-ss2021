import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


class Translator {
    public Translator() { }

    /**
    * Übersetzt einen Satz von einer Ausgangs- in eine Zielsprache. 
    * @param sourceLanguage Ausgangssprache
    * @param targetLanguage Zielsprache
    * @param text zu übersetzender Text
    * @return text in Zielsprache
    */
    public String translateSentence(String sourceLanguage, 
            String targetLanguage,
            String text) { 
        return text + "x"; 
    }
}


public class UebersetzerApp extends Application {
    /**
    * Liefert die Sprachenliste ohne die Ausgangssprache als ObservableList 
    * @param allLanguages Liste mit allen Sprachen
    * @param sourceLanguage gewählte Ausgangssprache
    * @return Sprachliste
    */
    private ObservableList<String> getTargetLanguages(List<String> allLanguages, String sourceLanguage) {
        return FXCollections.observableArrayList(
                allLanguages.stream().filter(el -> !el.equals(sourceLanguage)).collect(Collectors.toList()));
    }

    @Override
    public void start(Stage stage) {
        List<String> allLanguages = Arrays.asList("Deutsch", "Englisch", "Französisch", "Russisch");
        ObservableList<String> sprachen = FXCollections.observableList(allLanguages);
        /* ab hier: Teilaufgabe b) Aufbau des Dialogs */
        
        VBox vbox = new VBox();
        GridPane grid = new GridPane();
        
        Label labelFrom = new Label("Ausgangssprache");
        Label labelTo = new Label("Zielsprache");
        
        ChoiceBox<String> from = new ChoiceBox<>();
        ChoiceBox<String> to = new ChoiceBox<>();
        
        TextArea input = new TextArea();
        TextArea output = new TextArea();
        
        Button translate = new Button("übersetzen");

        grid.add(labelFrom, 0, 0);
        grid.add(from, 1, 0);
        grid.add(labelTo, 0, 1);
        grid.add(to, 1, 1);
        
        vbox.getChildren().addAll(grid, input, translate, output);
        
        from.setItems(sprachen);
        from.getSelectionModel().select(0);
        to.setItems(getTargetLanguages(allLanguages, sprachen.get(0)));
        to.getSelectionModel().select(0);
        
        /* To-ChoiceBox modifizieren wenn From-ChoiceBox geändert wird */
        
        // Frage: Wie Ereignisse von JavaFX Controls abfangen?
        // -> Wie haben Sie Ereignisse im Praktikum auf den Buttons verarbeitet?
        // -> setOnMouseClick -> EventHandler<MouseEvent>
        // -> **setOnAction** -> EventHandler<ActionEvent>
        from.setOnAction(action -> {
            // hier beschreiben was passiert...
            // - to ChoiceBox neu befüllen
            // -> to.setItems(getTargetLanguages(allLanguages, ???))
            String fromLanguage = from.getSelectionModel().getSelectedItem();
            to.setItems(getTargetLanguages(allLanguages, fromLanguage));
            //to.getSelectionModel().select(0);
        });

        /* Übersetzen bei Klick von Button */
        translate.setOnAction(action -> {
            // Frage: was muss passieren?
            // -> translateSentence aufrufen
            //    -> text aus input 
            //    -> Sprachen aus den ChoiceBoxen
            String fromLanguage = from.getSelectionModel().getSelectedItem();
            String toLanguage = to.getSelectionModel().getSelectedItem();
            String text = input.getText();
            Translator translator = new Translator();
            String result = translator.translateSentence(fromLanguage, toLanguage, text);
            output.setText(result);
        });

        Scene scene = new Scene(vbox);
        
        stage.setScene(scene);
        stage.show();
    }
}