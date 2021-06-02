package first;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloWorldMitJavaFX extends Application {

    public void init() throws Exception {
        System.out.println("Init");
    }

    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");
        
        // Fenstermodifikation, hier das setzen des Fenstertitels
        primaryStage.setTitle("Hello World Fenster");

        // Irgendwelcher Inhalt, hier ein Label und ein FlowPane
        Pane pane = new FlowPane(); // Pane, bzw. Struktur oder Layout-Element
        Label label = new Label("Hello World!"); // Control!
        
        HandleFirstClick value = new HandleFirstClick();
        label.setOnMouseClicked(value);
        
        pane.getChildren().add(label); // fügen wir Control zu Layout hinzu
        
        

        // Erstellen einer Szene
        Scene scene = new Scene(pane, 300, 200);
        // Szene der Stage bekannt geben
        primaryStage.setScene(scene);
        // Stage anzeigen, Fenster anzeigen
        primaryStage.show();
        
        
        // Man kann jederzeit ein(e) neue(s) Fenster/Stage erzeugen
//        Stage stage = new Stage();
//        stage.setTitle("Subfenster");
//
//        // Inhalt muss neu erzeugt werden für Subfenster
//        Pane pane2 = new FlowPane(); // Pane, bzw. Struktur oder Layout-Element
//        Label label2 = new Label("Hello Someone!"); // Control!
//        pane2.getChildren().add(label2); // fügen wir Control zu Layout hinzu
//        
//        // Szene erzeugen
//        Scene scene2 = new Scene(pane2, 200, 100);
//        // Szene an Stage übergeben
//        stage.setScene(scene2);
//        // Stage anzeigen
//        stage.initOwner(primaryStage);
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.show();
    }
    
    public void stop() throws Exception {
        System.out.println("Stop");
    }
    
    public static void main(String[] args) {
        // (Geht nicht mit Maven in Kombination)
        launch(args);
    }

}