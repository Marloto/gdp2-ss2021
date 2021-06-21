package de.thi.informatik.gdp2.simplewebapp;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;

/**
 * Special event which help to handle the startup process of
 * JavaFX in a spring boot component.
 */
@SuppressWarnings("serial")
public class StageReadyEvent extends ApplicationEvent {
	public StageReadyEvent(Stage stage) {
		super(stage);
	}

	public Stage getStage() {
		return ((Stage) getSource());
	}
}