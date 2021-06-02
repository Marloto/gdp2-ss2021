package first;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class HandleFirstClick implements EventHandler<MouseEvent> {
    public void handle(MouseEvent event) {
        // mit der beschrieben wird, was passiert, wenn geklickt wird...
        System.out.println("Test...");
    }
}
