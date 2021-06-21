package de.thi.informatik.gdp2.simplewebapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private long time;
	private String user;
	private String message;
	
	public Message(String user, String message) {
		this.user = user;
		this.message = message;
		this.time = System.currentTimeMillis();
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getUser() {
		return user;
	}
	
	public long getTime() {
		return time;
	}

    public String toFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(new Date(time));
    }
	
	@Override
	public String toString() {
		return this.getUser() + "(" + this.toFormattedTime() + "): " + this.getMessage();
	}
}
