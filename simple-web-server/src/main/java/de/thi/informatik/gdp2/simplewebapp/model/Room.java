package de.thi.informatik.gdp2.simplewebapp.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
	private String name;
	private List<Message> list;

	public Room(String name) {
		this.name = name;
		this.list = new LinkedList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addMessage(String user, String message) {
		this.list.add(new Message(user, message));
	}
	
	public List<Message> getMessagesSince(long time) {
	    // Filtert alle Messages ab einem bestimmten Zeitpunkt und 
	    // liefert diese dann in einer liste zurück
		return this.list.stream()
		        .filter(msg -> msg.getTime() >= time)
		        .collect(Collectors.toList());
	}
}
