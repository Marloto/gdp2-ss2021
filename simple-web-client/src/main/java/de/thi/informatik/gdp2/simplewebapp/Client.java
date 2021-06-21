package de.thi.informatik.gdp2.simplewebapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javafx.application.Application;

/**
 * Common main method to start JavaFX applications.
 */
@SpringBootApplication
public class Client {
	public static void main(String[] args) {
        Application.launch(ChatApplication.class, args);
	}
	
	/**
	 * Creates REST-service accessor instance used in ChatController
	 * 
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplateBuilder().build();
	}
	
}
