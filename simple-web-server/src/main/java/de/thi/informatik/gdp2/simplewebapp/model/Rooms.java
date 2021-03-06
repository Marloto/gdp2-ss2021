package de.thi.informatik.gdp2.simplewebapp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component // Markiert diese Klasse als eine "Komponente" in Spring, dadurch
           // kann die Klasse über Dependency Injection an anderer Stelle genutzt
           // werden
public class Rooms {
	private Map<String, Room> map;

	public Rooms() {
		this.map = new HashMap<>();
		this.addRoom("Stuff");
		this.addRoom("Funny");
		this.addRoom("Awesome");
	}
	
	public void addRoom(String name) {
		this.map.put(name, new Room(name));
	}

	public Set<String> getRooms() {
		return map.keySet();
	}
	
	public Room getRoom(String name) {
		return this.map.get(name);
	}
}
