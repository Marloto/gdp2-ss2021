package de.thi.informatik.gdp2.simplewebapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main controller class to handle JavaFX application scene. Instance is not created 
 * manually. Spring creates this component while starting.
 */
@Component
public class ChatController implements ApplicationListener<StageReadyEvent> {
	
	private RestTemplate rest;
	private Stage stage;

	/**
	 * This constructor is called automatically by spring. Spring 
	 * ensures that the required parameter is provided within this 
	 * construction process.
	 * 
	 * @param rest
	 */
	@Autowired
	public ChatController(RestTemplate rest) {
		this.rest = rest;
	}
	
	@Override
	public void onApplicationEvent(StageReadyEvent event) {
		stage = event.getStage();
		showLogin();
		stage.show();
	}
	
	private void showChat() {
		
	}
	

	private void showLogin() {
		
	}

}
