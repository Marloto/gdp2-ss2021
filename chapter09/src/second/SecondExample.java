package second;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

class NotPublicStandaloneAction 
    implements EventHandler<ActionEvent> {
    
    private Button button;
    
    public NotPublicStandaloneAction(Button button) {
        this.button = button;
    }
    
    public void handle(ActionEvent event) {
        String text = button.getText();
        button.setText(text + "!");
    }
}

public class SecondExample extends Application {

    private Button button;

    public class InnerClassAction 
        implements EventHandler<ActionEvent> {
    
        @Override
        public void handle(ActionEvent event) {
            String text = button.getText();
            
            // Explizite Auswahl von Attribut/Methode
            // über <KlassenName>.this.<attribut>
            // SecondExample.this.button.setText(text + "!");
            button.setText(text + "!");
        }
    }

    public static class InnerStaticClassAction 
        implements EventHandler<ActionEvent> {

        private Button button;

        public InnerStaticClassAction(Button button) {
            this.button = button;
        }
        
        @Override
        public void handle(ActionEvent event) {
            String text = button.getText();
            button.setText(text + "!");
        }
    }
    
    public static void main(String[] args) {
        // geht für innere klassen nicht, muss aus
        // konstruktor oder methode passieren
        // new InnerClassAction();
    }
    
    public void start(Stage primaryStage) throws Exception {
        button = new Button("Drück mich!");
        
        //InnerStaticClassAction handler = 
        //        new InnerStaticClassAction(button);
        
        // Anonyme Innere Klasse
//        EventHandler<ActionEvent> handler = 
//                new EventHandler<ActionEvent>() {
//                    public void handle(ActionEvent event) {
//                        String text = button.getText();
//                        button.setText(text + "!");
//                        primaryStage.setTitle(text);
//                    }
//        };
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String text = button.getText();
                button.setText(text + "!");
                primaryStage.setTitle(text);
            }
        });
        
//        button.setOnAction((event) -> {
//            String text = button.getText();
//            button.setText(text + "!");
//        });
        
        Scene scene = new Scene(button, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
