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
	private String room;
	private String username;
	private TextArea chat;

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
		TextField msg = new TextField();
		msg.setPrefColumnCount(50);
		Button submit = new Button("Submit");
		chat = new TextArea();
		chat.setPrefRowCount(20);
		
		VBox main = new VBox();
		HBox form = new HBox();
		
		form.getChildren().addAll(msg, submit);
		main.getChildren().addAll(form, chat);
		
		submit.setOnAction(event -> {
			rest.postForObject("http://localhost:8080/room/" + room + "/" + username, msg.getText(), void.class);
			msg.setText("");
		});
		
		Scene scene = new Scene(main);
		this.stage.setScene(scene);
		
		new Thread(new Refresher()).start();
	}
	
	class Refresher implements Runnable {

		private long last;

		@Override
		public void run() {
			while(true) {
				String[] messages = rest.getForObject("http://localhost:8080/room/" + room + "/" + last, String[].class);
				last = System.currentTimeMillis();
				Platform.runLater(() -> {
					for(String msg : messages) {
						chat.setText(msg + "\n" + chat.getText());
					}
				});
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private void showLogin() {
		TextField usernameField = new TextField();
		Label usernameLabel = new Label("Username: ");
		
		String[] forEntity = rest.getForObject("http://localhost:8080/rooms", String[].class);
		ChoiceBox<String> rooms = new ChoiceBox<>();
		rooms.setItems(FXCollections.observableArrayList(Arrays.asList(forEntity)));
		rooms.getSelectionModel().select(0);

		Button login = new Button("Login");
		login.setOnAction(event -> {
			room = rooms.getSelectionModel().getSelectedItem();
			username = usernameField.getText();
			showChat();
		});
		
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(usernameLabel, usernameField, rooms, login);
		
		stage.setScene(new Scene(hBox, 400, 100));
	}

}
