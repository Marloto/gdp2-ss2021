package de.thi.informatik.gdp2.simplewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Spring benötigt die Annotation, damit diese Klasse als Basis-Anwendung
                       // mit Spring gestartet wird
public class Server {

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}
	
	// u.a. @Bean

}
