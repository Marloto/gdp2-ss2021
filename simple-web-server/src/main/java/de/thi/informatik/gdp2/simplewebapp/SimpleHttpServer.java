package de.thi.informatik.gdp2.simplewebapp;

import java.net.*;

public class SimpleHttpServer {
	public static void main(String[] args) throws Exception {
		// Einfache Implementierung eines TCP Socket Servers
		// Normalerweise sollte das Ergebnis aus socket.accept() in einem neuen Thread 
		// verarbeitet werden, dort mittels getInputStream() die eingehenden Daten verarbeitet
		// und entsprechend mittels getOutputStream die ausgehenden Informationen liefern.
		// ----
		// Besser und effizienter wäre die Verwendung von java.nio-Klassen, deren Verwendung ist
		// aber nicht trivial.
		// ----
		try (ServerSocket socket = new ServerSocket(8000)) { 			// Starte Server auf Port 8000
			while(true) {												// Endlosschleife
				try(Socket client = socket.accept()) {					// Warte auf eingehende Verbindungen (blockierend)
					client.getOutputStream().write((					// Sende ohne Verarbeitung der Anfrage eine Antwort
							"HTTP/1.0 200 OK\nContent-Length: 13\n\n" +
							"Hello, World!").getBytes());
				}
			}
		}
	}
}
