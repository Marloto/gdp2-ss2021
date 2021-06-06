package fixTest;

import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import javafx.stage.Stage;

public class ZeitMessung extends Application {
    long time = 0;

    public void start(Stage primaryStage) {
        Button button = new Button("Messe");
        Label label = new Label();

        FlowPane pane = new FlowPane();

        pane.getChildren().addAll(label, button);

        Scene scene = new Scene(pane, 300, 275);

        button.setMinWidth(50);
        button.setMinHeight(30);

        primaryStage.setScene(scene);

        label.setText(".......");

        primaryStage.show();

        button.setOnAction(e ->
        {
            label.setText(String.valueOf(System.currentTimeMillis() - time));
        });
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg) {
                if(time == 0) {
                    time = System.currentTimeMillis();
                } else {
                    long diff = System.currentTimeMillis() - time;

                    label.setText(String.valueOf(diff));
                }
                time = System.currentTimeMillis();
            }
        });
    }
}
