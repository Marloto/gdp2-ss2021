package de.thi.informatik.gdp2.simplewebapp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.thi.informatik.gdp2.simplewebapp.model.Message;
import de.thi.informatik.gdp2.simplewebapp.model.Room;
import de.thi.informatik.gdp2.simplewebapp.model.Rooms;

@RestController // markiert die Klasse als HTTP-Endpunkt
                // -> siehe Webtechnologien im nächsten Semester
public class ChatEndpoint {
    @Autowired
    private Rooms rooms; // Dependency Injection
                         // vgl. Java EE / Spring
    
    @GetMapping("/hello") // -> vgl. GET-HTTP-Methode, i.R. Standardanfragen 
                          // direkt in der URL-Leiste des Browser
                          // http://localhost:8080/hello
    public String doSomething() {
        return "Hello, World!";
    }
    
    // 1. Auflisten aller Räume
    @GetMapping("/rooms") // -> http://localhost:8080/rooms
    public String[] listRooms() {
        Set<String> rooms = this.rooms.getRooms();

        // (1) Variante mit Iteration:
        // String[] arr = new String[rooms.size()];
        // int i = 0;
        // for(String e : rooms) {
        //     arr[i ++] = e;
        // }

        // (2) Variante mit toArray-Methode am Set:
        return rooms.toArray(new String[0]); // platzhalter!
    }
    
    // 2. Auflisten aller Nachrichten seit
    //   http://localhost:8080/room/Stuff/10000
    //   {room} kann über Parameter der Methode genutzt werden, 
    //   hierfür ist @PathVariable notwendig
    @GetMapping("/room/{room}/{since}")
    public String[] listMessages(
            @PathVariable String room, 
            @PathVariable Long since) {
        
        // Alle Nachrichten finden aus dem Model finden
        Room roomRef = this.rooms.getRoom(room);
        List<Message> list = rooms.getRoom(room).getMessagesSince(since);

        // (1) Variante ohne Stream:
        // String[] result = new String[list.size()];
        // int i = 0;
        // for(Message e : list) {
        //     result[i ++] = e.toString();
        // }
        
        // (2) Variante mit toArray-Terminal-Operation
        return list
            .stream()
            .map(msg -> msg.toString()) // od. Message::toString
            .toArray(size -> new String[size]);

        // (3) Variante mit collect-Terminal-Operation
        // return list
        //    .stream()
        //    .map(msg -> msg.toString()) // od. Message::toString
        //    .collect(Collectors.toList())
        //    .toArray(new String[0]);
    }
    
    // 3. Absenden einer Nachricht
    // -> Als POST-Anfrage http://localhost:8080/Stuff/IrgendEinUser (geht nicht im Browser!)
    // -> zum Testen ggf. "Postman", "Advanced REST Client" oder in der Shell wget, cURL
    @PostMapping("/room/{name}/{user}")
    public void addMessage(@PathVariable String name, @PathVariable String user, @RequestBody String message) {
        Room room = rooms.getRoom(name);
        room.addMessage(user, message);
    }
    
}
