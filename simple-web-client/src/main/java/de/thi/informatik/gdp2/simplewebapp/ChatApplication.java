package de.thi.informatik.gdp2.simplewebapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * JavaFX Application with integrated Spring startup, nothing to do 
 * here. JavaFX application building is done in ChatController.
 */
public class ChatApplication extends Application {
	private ConfigurableApplicationContext applicationContext;

	public void init() {
		String[] args = getParameters().getRaw().toArray(new String[0]);
		applicationContext = new SpringApplicationBuilder()
				.sources(Client.class)
				.run(args);
	}

	public void start(Stage primaryStage) throws Exception {
		applicationContext.publishEvent(new StageReadyEvent(primaryStage));
	}

	public void stop() {
		applicationContext.close();
		Platform.exit();
	}

}
